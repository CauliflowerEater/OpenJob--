package io.openjob.server.scheduler.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.openjob.common.constant.FailStatusEnum;
import io.openjob.common.constant.TaskStatusEnum;
import io.openjob.common.request.WorkerDelayAddRequest;
import io.openjob.common.request.WorkerDelayPullRequest;
import io.openjob.common.request.WorkerDelayStatusRequest;
import io.openjob.common.request.WorkerDelayTaskRequest;
import io.openjob.common.request.WorkerDelayTopicPullRequest;
import io.openjob.common.response.ServerDelayAddResponse;
import io.openjob.common.response.ServerDelayInstanceResponse;
import io.openjob.common.response.ServerDelayPullResponse;
import io.openjob.common.response.ServerDelayTopicPullResponse;
import io.openjob.common.response.ServerDelayTopicResponse;
import io.openjob.server.alarm.constant.AlarmEventEnum;
import io.openjob.server.alarm.dto.AlarmEventDTO;
import io.openjob.server.alarm.event.AlarmEvent;
import io.openjob.server.alarm.event.AlarmEventPublisher;
import io.openjob.server.common.util.BeanMapperUtil;
import io.openjob.server.scheduler.dto.DelayInstanceAddRequestDTO;
import io.openjob.server.scheduler.dto.DelayInstanceAddResponseDTO;
import io.openjob.server.scheduler.dto.DelayInstancePullResponseDTO;
import io.openjob.server.scheduler.dto.DelayInstanceStatusRequestDTO;
import io.openjob.server.scheduler.dto.DelayItemPullRequestDTO;
import io.openjob.server.scheduler.dto.DelayTopicPullDTO;
import io.openjob.server.scheduler.dto.DelayTopicPullRequestDTO;
import io.openjob.server.scheduler.dto.DelayTopicPullResponseDTO;
import io.openjob.server.scheduler.scheduler.DelayInstanceScheduler;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class DelayInstanceService {
    private final DelayInstanceScheduler delayInstanceScheduler;

    @Autowired
    public DelayInstanceService(DelayInstanceScheduler delayInstanceScheduler) {
        this.delayInstanceScheduler = delayInstanceScheduler;
    }

    /**
     * Pull instance.
     * 来自单个worker的请求；
     * 同时对应多个topic拉取相应数量的instance；
     *
     * @param pullRequest pull request.
     * @return ServerDelayPullResponse
     */
    public ServerDelayPullResponse pullInstance(WorkerDelayPullRequest pullRequest) {
        List<ServerDelayInstanceResponse> responses = new ArrayList<>();

        // Pull delay instance.
        pullRequest
                .getPullItems()
                .forEach(item -> {
                    DelayItemPullRequestDTO delayItemPullRequestDTO = BeanMapperUtil.map(item, DelayItemPullRequestDTO.class);
                    List<DelayInstancePullResponseDTO> responseList = this.delayInstanceScheduler.pullByTopic(pullRequest.getWorkerAddress(), delayItemPullRequestDTO);
                    responses.addAll(BeanMapperUtil.mapList(responseList, DelayInstancePullResponseDTO.class, ServerDelayInstanceResponse.class));
                });

        ServerDelayPullResponse delayPullResponse = new ServerDelayPullResponse();
        delayPullResponse.setDelayInstanceResponses(responses);
        return delayPullResponse;
    }

    /**
     * Add delay instance.
     * 添加一个DelayInstance;
     * 根据topic存入响应的zset和addlist;
     *
     * @param addRequest add request.
     * @return ServerDelayAddResponse
     */
    public ServerDelayAddResponse addDelayInstance(WorkerDelayAddRequest addRequest) {
        ServerDelayAddResponse serverDelayAddResponse = new ServerDelayAddResponse();
        DelayInstanceAddRequestDTO addRequestDTO = BeanMapperUtil.map(addRequest, DelayInstanceAddRequestDTO.class);
        DelayInstanceAddResponseDTO addResponseDTO = this.delayInstanceScheduler.add(addRequestDTO);
        //如果add成功会返回taskId(用DTO封装)，如果add失败会返回null；
        serverDelayAddResponse.setTaskId(addResponseDTO.getTaskId());
        return serverDelayAddResponse;
    }

    /**
     * Pull topic list.
     *
     * @param pullRequest pullRequest
     * @return ServerDelayTopicPullResponse
     */
    public ServerDelayTopicPullResponse pullTopicList(WorkerDelayTopicPullRequest pullRequest) {
        DelayTopicPullRequestDTO delayTopicPullRequestDTO = BeanMapperUtil.map(pullRequest, DelayTopicPullRequestDTO.class);

        DelayTopicPullResponseDTO topicListDTO = this.delayInstanceScheduler.pullTopicList(delayTopicPullRequestDTO);
        ServerDelayTopicPullResponse response = new ServerDelayTopicPullResponse();
        response.setTopicList(BeanMapperUtil.mapList(topicListDTO.getTopicList(), DelayTopicPullDTO.class, ServerDelayTopicResponse.class));
        return response;
    }

    /**
     * Handle delay status.
     * 调用DelayInstanceScheduler的report方法;
     * report方法会筛选出Delay status为complete的instance,删除掉响应taskId的detail, zset, addlist;
     * 将request转发到statusScheduler调度;
     *
     * @param workerDelayStatusRequest workerDelayStatusRequest
     */
    public void handleConsumerDelayStatus(WorkerDelayStatusRequest workerDelayStatusRequest) {
        List<DelayInstanceStatusRequestDTO> statusList = BeanMapperUtil.mapList(workerDelayStatusRequest.getTaskList(), WorkerDelayTaskRequest.class, DelayInstanceStatusRequestDTO.class);

        this.addAlarmEvent(statusList);
        this.delayInstanceScheduler.report(statusList);
    }

    protected void addAlarmEvent(List<DelayInstanceStatusRequestDTO> statusList) {
        statusList.forEach(s -> {
            if (TaskStatusEnum.isFailed(s.getStatus())) {
                AlarmEventDTO alarmEventDTO = new AlarmEventDTO();
                alarmEventDTO.setJobUniqueId(s.getTopic());
                alarmEventDTO.setInstanceId(s.getTaskId());

                // Delay worker task status(fail/timeout)
                if (FailStatusEnum.isExecuteFail(s.getFailStatus())) {
                    alarmEventDTO.setName(AlarmEventEnum.DELAY_EXECUTE_FAIL.getEvent());
                } else {
                    alarmEventDTO.setName(AlarmEventEnum.DELAY_EXECUTE_TIMEOUT.getEvent());
                }

                // Event message
                alarmEventDTO.setMessage(s.getResult());
                AlarmEventPublisher.publishEvent(new AlarmEvent(alarmEventDTO));
            }
        });
    }
}

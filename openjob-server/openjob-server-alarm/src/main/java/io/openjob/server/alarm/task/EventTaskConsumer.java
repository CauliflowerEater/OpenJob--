package io.openjob.server.alarm.task;

import java.util.List;

import io.openjob.common.OpenjobSpringContext;
import io.openjob.common.task.BaseConsumer;
import io.openjob.common.task.TaskQueue;
import io.openjob.server.alarm.dto.AlarmEventDTO;
import io.openjob.server.alarm.service.AlarmService;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class EventTaskConsumer extends BaseConsumer<AlarmEventDTO> {
    public EventTaskConsumer(Long id,
            Integer consumerCoreThreadNum,
            Integer consumerMaxThreadNum,
            String consumerThreadName,
            Integer pollSize,
            String pollThreadName, TaskQueue<AlarmEventDTO> queues) {
        super(id, consumerCoreThreadNum, consumerMaxThreadNum, consumerThreadName, pollSize, pollThreadName, queues, 5000L, 5000L);
    }

    @Override
    public void consume(Long id, List<AlarmEventDTO> tasks) {
        this.consumerExecutor.submit(new EventTaskRunnable(tasks));
    }

    private static class EventTaskRunnable implements Runnable {
        private final List<AlarmEventDTO> tasks;

        private EventTaskRunnable(List<AlarmEventDTO> tasks) {
            this.tasks = tasks;
        }

        @Override
        public void run() {
            try {
                OpenjobSpringContext
                        .getBean(AlarmService.class)
                        .alarm(this.tasks);
            } catch (Throwable throwable) {
                log.error("Alarm event consume failed!", throwable);
            }
        }
    }
}

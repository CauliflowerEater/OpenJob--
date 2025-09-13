package io.openjob.server.scheduler.dto;

import java.util.List;

import lombok.Data;

/**
 * @author stelin swoft@qq.com
 * @since 1.0.0
 */
@Data
public class DelayTopicPullResponseDTO {
    private List<DelayTopicPullDTO> topicList;
}

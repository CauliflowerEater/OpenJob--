package io.openjob.server.scheduler.dto;

import lombok.Data;


@Data
public class TaskListPullRequestDTO {

    /**
     * Instance id.
     */
    private Long jobInstanceId;

    /**
     * Circle id
     */
    private Long circleId;
}

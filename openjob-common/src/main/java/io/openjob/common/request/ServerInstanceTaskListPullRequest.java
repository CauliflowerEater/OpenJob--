package io.openjob.common.request;

import java.io.Serializable;

import lombok.Data;


@Data
public class ServerInstanceTaskListPullRequest implements Serializable {

    /**
     * Job instance id
     */
    private Long jobInstanceId;

    /**
     * Job dispatch version
     */
    private Long dispatchVersion;

    /**
     * Circle id
     */
    private Long circleId;
}

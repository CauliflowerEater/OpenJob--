package io.openjob.common.response;

import java.io.Serializable;
import java.util.List;

import lombok.Data;


@Data
public class ServerDelayTopicPullResponse implements Serializable {
    private List<ServerDelayTopicResponse> topicList;
}

package io.openjob.server.alarm.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class FeishuResponse {
    @JsonProperty(value = "StatusCode")
    private Integer statusCode;

    @JsonProperty(value = "StatusMessage")
    private String statusMessage;

    @JsonProperty(value = "code")
    private Integer code;

    @JsonProperty(value = "msg")
    private String msg;

    @JsonProperty(value = "data")
    private Object data;
}

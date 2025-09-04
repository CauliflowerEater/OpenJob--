package io.openjob.server.alarm.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class WebhookResponse {
    @JsonProperty(value = "errcode")
    private Integer errCode;

    @JsonProperty(value = "errmsg")
    private String errMsg;
}

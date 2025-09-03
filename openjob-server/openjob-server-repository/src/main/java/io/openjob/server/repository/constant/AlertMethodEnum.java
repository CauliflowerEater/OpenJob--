package io.openjob.server.repository.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum AlertMethodEnum {
    /**
     * Fei shu
     */
    FEISHU("feishu"),

    /**
     * Ding ding.
     */
    DINGDING("dingding"),

    /**
     * Wecom
     */
    WECOM("wecom"),

    /**
     * Webhook
     */
    WEBHOOK("webhook"),
    ;

    private final String type;

    public static Boolean isWecom(String method) {
        return WECOM
                .getType()
                .equals(method);
    }
}

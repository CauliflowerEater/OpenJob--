package io.openjob.server.repository.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public enum PermissionTypeEnum {
    /**
     * menu.
     */
    MENU(1, "menu"),

    /**
     * Stop.
     */
    PERMISSION(2, "permission"),
    ;

    private final Integer type;
    private final String message;
}

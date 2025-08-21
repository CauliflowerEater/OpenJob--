package io.openjob.common.dto;

import io.openjob.common.constant.ShellTypeEnum;
import lombok.Data;


@Data
public class ShellProcessorDTO {
    /**
     * Content
     */
    private String content;

    /**
     * Type
     *
     * @see ShellTypeEnum
     */
    private String type;
}

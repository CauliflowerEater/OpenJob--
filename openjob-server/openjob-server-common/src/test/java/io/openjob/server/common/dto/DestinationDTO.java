package io.openjob.server.common.dto;

import lombok.Data;


@Data
public class DestinationDTO {
    private Integer id;
    private String name;
    private Boolean type;
    private Long time;
}

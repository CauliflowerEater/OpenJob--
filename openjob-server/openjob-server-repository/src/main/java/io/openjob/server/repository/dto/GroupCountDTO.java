package io.openjob.server.repository.dto;

import lombok.Data;


@Data
public class GroupCountDTO {
    private Integer groupBy;
    private Long count;

    public GroupCountDTO(Integer groupBy, Long count) {
        this.groupBy = groupBy;
        this.count = count;
    }
}

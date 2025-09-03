package io.openjob.server.common.vo;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PageVO<T> {


    @ApiModelProperty("Current page.")
    private Integer page;

    @ApiModelProperty("Page size.")
    private Integer size;

    @ApiModelProperty("Page total.")
    private Long total;

    @ApiModelProperty("Data list.")
    private List<T> list;

}

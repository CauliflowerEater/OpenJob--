package io.openjob.server.common.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class PageDTO<T> {

    private Integer page;

    private Integer size;

    private Long total;

    private List<T> list;

    public PageDTO() {
        this.page = 1;
        this.size = 10;
        this.total = 0L;
        this.list = new ArrayList<>();
    }

}

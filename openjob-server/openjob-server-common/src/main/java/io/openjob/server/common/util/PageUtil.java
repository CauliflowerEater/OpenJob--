package io.openjob.server.common.util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.util.CollectionUtils;

import com.google.common.collect.Lists;

import io.openjob.server.common.dto.PageDTO;
import io.openjob.server.common.vo.PageVO;

public class PageUtil {

    /**
     * Convert
     *
     * @param pageDTO  Page dtp
     * @param function Function
     * @param <S>      Target type
     * @param <T>      PageVo
     * @return source type
     */
    public static <S, T> PageVO<T> convert(PageDTO<S> pageDTO, Function<S, T> function) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setSize(pageDTO.getSize());
        pageVO.setTotal(pageDTO.getTotal());
        pageVO.setPage(pageDTO.getPage());

        List<T> list = Lists.newArrayList();
        if (!CollectionUtils.isEmpty(pageDTO.getList())) {
            list = pageDTO
                    .getList()
                    .stream()
                    .map(function)
                    .collect(Collectors.toList());
        }

        pageVO.setList(list);
        return pageVO;
    }

    /**
     * Empty
     *
     * @param pageDTO pageDTO
     * @param <S>     t
     * @param <T>     PageVO
     * @return s
     */
    public static <S, T> PageVO<T> empty(PageDTO<S> pageDTO) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setSize(pageDTO.getSize());
        pageVO.setTotal(pageDTO.getTotal());
        pageVO.setPage(pageDTO.getPage());
        pageVO.setList(Lists.newArrayList());
        return pageVO;
    }

    /**
     * Empty list page vo.
     *
     * @param tClass tClass class type.
     * @param <T>    type
     * @return PageVO
     */
    public static <T> PageVO<T> emptyList(Class<T> tClass) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setSize(10);
        pageVO.setTotal(0L);
        pageVO.setPage(1);
        pageVO.setList(Lists.newArrayList());
        return pageVO;
    }
}

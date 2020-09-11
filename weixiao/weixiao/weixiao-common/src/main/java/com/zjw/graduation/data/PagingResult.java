package com.zjw.graduation.data;


import java.io.Serializable;
import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;


public class PagingResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int pageIndex;

    private int pageSize;

    private List<T> entities;

    private Long totalRecords;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public PagingResult() {
    }

    public Long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<T> getEntities() {
        return entities;
    }

    public void setEntities(List<T> entities) {
        this.entities = entities;
    }

    /**
     * PagingResult 的泛型转换
     *
     * @param mapper 转换函数
     * @param <R>    转换后的泛型
     * @return 转换泛型后的 PagingResult
     */
    @SuppressWarnings("unchecked")
    public <R> PagingResult<R> convert(Function<? super T, ? extends R> mapper) {
        List<R> collect = this.getEntities().stream().map(mapper).collect(toList());
        ((PagingResult<R>) this).setEntities(collect);
        return (PagingResult<R>) this;
    }

    @Override
    public String toString() {
        return "PagingResult [totalRecords:" + totalRecords + ", entities:" + entities.size() + "]";
    }
}

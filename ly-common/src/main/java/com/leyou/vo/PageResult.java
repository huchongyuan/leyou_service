package com.leyou.vo;/*
 *@params com.leyou.vo
 *@description
 *@auth huchongyuan
 *@create 2020-05-16 08:
 */

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {
    private Long total; // 总条数
    private Integer totalPage; //总页数
    private List<T> items;

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }
}

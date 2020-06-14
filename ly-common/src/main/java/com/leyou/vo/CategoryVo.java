package com.leyou.vo;

import lombok.Data;

import java.util.List;

/*
 *@params com.leyou.vo
 *@description
 *@auth huchongyuan
 *@create 2020-05-19 17:
 */
@Data
public class CategoryVo {
    private Long value;
    private String title;
    private Long parentId;
    private Boolean isParent;
    private Long key;
    private List<CategoryVo> children;
}

package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

/*
 *@params com.leyou.item.pojo
 *@description 商品分类实体类
 *@auth huchongyuan
 *@create 2020-05-09 20:38
 */
@Table(name = "tb_category")
@Data
public class Category {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private Long parentId;
    private Boolean isParent;
    private Integer sort;
    private List<Category> children;
}

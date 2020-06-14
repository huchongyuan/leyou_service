package com.leyou.item.pojo;/*
 *@params com.leyou.item.pojo
 *@description
 *@auth huchongyuan
 *@create 2020-06-13 16:
 */

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "tb_spec_group")
@Data
public class SpecGroup {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private Long cid;
    private String name;
}

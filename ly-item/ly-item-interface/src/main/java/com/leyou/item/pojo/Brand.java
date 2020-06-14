package com.leyou.item.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/*
 *@params com.leyou.item.pojo
 *@description 品牌POJO
 *@auth huchongyuan
 *@create 2020-05-15 20:
 */
@Table(name="tb_brand")
@Data
public class Brand implements Serializable {
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long id;
    private String name;
    private String image;
    private String letter;
}

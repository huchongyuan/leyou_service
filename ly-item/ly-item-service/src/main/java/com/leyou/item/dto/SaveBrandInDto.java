package com.leyou.item.dto;/*
 *@params com.leyou.item.dto
 *@description
 *@auth huchongyuan
 *@create 2020-05-21 07:
 */

import com.leyou.item.pojo.Brand;
import lombok.Data;

import java.util.List;

@Data
public class SaveBrandInDto {
    private Brand brand;
    private List<Long> cids;
}

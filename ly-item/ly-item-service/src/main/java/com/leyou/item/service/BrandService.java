package com.leyou.item.service;

import com.leyou.item.pojo.Brand;
import com.leyou.vo.PageResult;

import java.util.List;

public interface BrandService {
    public PageResult<Brand> queryBrandByPage(
            Integer current,
            Integer pageSize,
            String sortBy,
            Boolean desc,
            String key
    );
    // 新增品牌
    public void saveBrand(Brand brand, List<Long> cids);
}

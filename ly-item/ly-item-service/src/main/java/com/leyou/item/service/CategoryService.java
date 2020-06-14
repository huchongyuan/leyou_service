package com.leyou.item.service;

import com.leyou.item.pojo.Category;
import com.leyou.vo.CategoryVo;
import com.leyou.vo.PageResult;

import java.util.List;

public interface CategoryService {
    PageResult<Category> queryCategoryListByPid(Long pid,Integer pageNum,Integer pageSize,String sortBy,Boolean desc);
    PageResult<CategoryVo> queryCategoryTreeByPid();
}

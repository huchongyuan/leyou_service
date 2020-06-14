package com.leyou.item.service.impl;
/*
 *@params com.leyou.item.service.impl
 *@description
 *@auth huchongyuan
 *@create 2020-05-09 20:
 */

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.enums.ExceptionEnum;
import com.leyou.exception.LyException;
import com.leyou.item.mapper.CategoryMapper;
import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import com.leyou.vo.CategoryVo;
import com.leyou.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public PageResult<Category> queryCategoryListByPid(Long pid, Integer pageNum, Integer pageSize, String sortBy, Boolean desc) {
        // 分页
        PageHelper.startPage(pageNum, pageSize);
        // 设置查询条件
        Example example = new Example(Category.class);
        example.createCriteria().andEqualTo("parentId", pid);
        // 排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<Category> categories = categoryMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(categories)) {
            throw new LyException(ExceptionEnum.CATEGORY_NOT_FOUND);
        }
        PageInfo<Category> categoryPageInfo = new PageInfo<>(categories);
        return new PageResult<Category>(categoryPageInfo.getTotal(), categoryPageInfo.getPages(), categories);
    }

    /*
     * 不分页查询商品分类树
     * */
    @Override
    public PageResult<CategoryVo> queryCategoryTreeByPid() {
        // 全部的分类数据
        List<Category> categories = categoryMapper.selectAll();
        // 全部转换成Vo对象
        List<CategoryVo> categoryVos = this.boTovo(categories);
        // 先找到所有的一级分类
        List<CategoryVo> rootCategory = new ArrayList<>();
        for (CategoryVo category : categoryVos) {
            if (category.getParentId().equals(0L)) {
                rootCategory.add(category);
            }
        }
        // 一级分类设置子类
        for (CategoryVo category : rootCategory) {
            category.setChildren(getChild(category.getValue(), categoryVos));
        }
        return new PageResult<CategoryVo>(0L, 0, rootCategory);
    }

    /*
     * 一级菜单带分页条件
     * @params List<Category> 当前页的所有一级菜单
     * @return 组装好的树
     * */
    public List<CategoryVo> getChild(Long id, List<CategoryVo> categories) {
        // 商品分类子类
        List<CategoryVo> children = new ArrayList<>();
        for (CategoryVo category : categories) {
            if (!category.getParentId().equals(0L)) {
                if (category.getParentId().equals(id)) {
                    children.add(category);
                }
            }
        }
        for (CategoryVo category : children) {
            if (category.getIsParent()) {
                category.setChildren(getChild(category.getValue(), categories));
            }
        }
        if (children.size() == 0) {
            return null;
        }
        return children;
    }

    /*
     *BO对象转换成VO对象
     * */
    public List<CategoryVo> boTovo(List<Category> categories) {
        List<CategoryVo> categoryVoList = new ArrayList<>();
        for (Category category : categories) {
            CategoryVo categoryVo = new CategoryVo();
            categoryVo.setTitle(category.getName());
            categoryVo.setParentId(category.getParentId());
            categoryVo.setValue(category.getId());
            categoryVo.setKey(category.getId());
            categoryVo.setIsParent(category.getIsParent());
            categoryVoList.add(categoryVo);
        }
        return categoryVoList;
    }
}

package com.leyou.item.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leyou.enums.ExceptionEnum;
import com.leyou.exception.LyException;
import com.leyou.item.mapper.BrandMapper;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import com.leyou.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


/*
 *@params com.leyou.item.service.impl
 *@description
 *@auth huchongyuan
 *@create 2020-05-15 21:
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPage(
            Integer current,
            Integer pageSize,
            String sortBy,
            Boolean desc,
            String key
    ) {
        // 分页
        PageHelper.startPage(current, pageSize);
        // 过滤
        Example example = new Example(Brand.class);
        if (StringUtils.isNotBlank(key)) {
            // 过滤条件:
            example.createCriteria().orLike("name", "%" + key + "%")
                    .orEqualTo("letter", key.toUpperCase());
        }
        // 排序
        if (StringUtils.isNotBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? "DESC" : "ASC");
            example.setOrderByClause(orderByClause);
        }
        // 查询
        List<Brand> brands = brandMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(brands)) {
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //获取分页信息:
        PageInfo<Brand> brandPageInfo = new PageInfo<>(brands);

        return new PageResult<Brand>(brandPageInfo.getTotal(),brandPageInfo.getPages(),brands);
    }
    /*
    * 新增品牌
    * @params brand cids
    * return
    * */
    @Override
    @Transactional
    public void saveBrand(Brand brand, List<Long> cids) {
        // count==1 成功  ==0 失败
        int count = brandMapper.insert(brand);
        if(count !=1){
            throw new LyException(ExceptionEnum.BRAND_SAVE_ERROR);
        }
        // 新增中间表
        for(Long cid:cids){
            count=brandMapper.insertCategoryBrand(cid,brand.getId());
            if(count !=1){
                throw new LyException(ExceptionEnum.BRAND_CATEGORY_SAVE_ERROR);
            }
        }
    }
}

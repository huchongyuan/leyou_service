package com.leyou.item.service.impl;/*
 *@params com.leyou.item.service.impl
 *@description
 *@auth huchongyuan
 *@create 2020-06-13 16:
 */

import com.leyou.enums.ExceptionEnum;
import com.leyou.exception.LyException;
import com.leyou.item.mapper.SpecGroupMapper;
import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.service.SpecGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpecGroupServiceImpl implements SpecGroupService {
    @Autowired
    SpecGroupMapper specGroupMapper;

    @Override
    public List<SpecGroup> queryGroupsById(Long cid) {
        SpecGroup specGroup = new SpecGroup();
        specGroup.setCid(cid);
        List<SpecGroup> select = specGroupMapper.select(specGroup);
        if (CollectionUtils.isEmpty(select)) {
            throw new LyException(ExceptionEnum.SPEC_GROUP_NOT_FOUND);
        }
        return select;
    }

    @Override
    public void addGroups(SpecGroup specGroup) {
        specGroupMapper.insert(specGroup);
    }
}

package com.leyou.item.service;

import com.leyou.item.pojo.SpecGroup;

import java.util.List;

public interface SpecGroupService {
    List<SpecGroup> queryGroupsById(Long cid);
    void addGroups(SpecGroup specGroup);
}

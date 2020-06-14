package com.leyou.item.web;/*
 *@params com.leyou.item.web
 *@description
 *@auth huchongyuan
 *@create 2020-06-13 16:
 */

import com.leyou.item.pojo.SpecGroup;
import com.leyou.item.service.SpecGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spec")
public class SpecGroupController {
    @Autowired
    SpecGroupService specGroupService;

    @GetMapping("/groups")
    public ResponseEntity<List<SpecGroup>> queryGroupsById(@RequestParam(value="cid") Long cid){
        System.out.println(cid);
        return ResponseEntity.ok(specGroupService.queryGroupsById(cid));
    }
    @PostMapping("/groups/add")
    public ResponseEntity<Void> addGroups(SpecGroup specGroup){
        specGroupService.addGroups(specGroup);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

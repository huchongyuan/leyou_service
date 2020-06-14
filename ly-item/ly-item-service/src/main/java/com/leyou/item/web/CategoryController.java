package com.leyou.item.web;

import com.leyou.item.pojo.Category;
import com.leyou.item.service.CategoryService;
import com.leyou.vo.CategoryVo;
import com.leyou.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 *@params com.leyou.item.web
 *@description 商品分类控制器
 *@auth huchongyuan
 *@create 2020-05-09 20:
 */
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /*
     * 根据父节点id查询商品分类
     * @param pid
     * @return
     * */
    @GetMapping("/list")
    public ResponseEntity<PageResult<Category>> queryCategoryListByPid(
            @RequestParam(value = "pid",defaultValue = "0") Long pid,
            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
            @RequestParam(value="sortBy",required=false) String sortBy,
            @RequestParam(value="desc",required=false) Boolean desc
    ) {
        return ResponseEntity.ok(
                categoryService.queryCategoryListByPid(pid, pageNum, pageSize, sortBy, desc)
        );
    }
    /*
    * 查询商品分类树
    * */
    @GetMapping("/tree")
    public ResponseEntity<PageResult<CategoryVo>> queryCategoryTreeByPid(){
        return ResponseEntity.ok(
                categoryService.queryCategoryTreeByPid()
        );
    }
}

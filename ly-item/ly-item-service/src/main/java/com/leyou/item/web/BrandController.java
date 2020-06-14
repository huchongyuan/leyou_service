package com.leyou.item.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.leyou.item.dto.SaveBrandInDto;
import com.leyou.item.pojo.Brand;
import com.leyou.item.service.BrandService;
import com.leyou.vo.PageResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 *@params com.leyou.item.web
 *@description
 *@auth huchongyuan
 *@create 2020-05-15 21:
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    /*
    * 分页查询品牌
    * @param current 当前页
    * @param pageSize 每页展示多少条
    * @param sortBy 排序字段
    * @param desc 升序降序
    * @param key 搜索关键字
    * */
    @GetMapping("/page")
    public ResponseEntity<PageResult<Brand>> queryBrandByPage(
            @RequestParam(value="pageNum",defaultValue="1") Integer current,// 当前页
            @RequestParam(value="pageSize",defaultValue = "10") Integer pageSize, // 一页显示多少条
            @RequestParam(value="sortBy",required = false) String sortBy, // 排序方式,默认可以不传
            @RequestParam(value="desc",defaultValue = "false") Boolean desc, // 升序 降序
            @RequestParam(value="keyWord",required = false) String key // 搜索条件
    ){
        return ResponseEntity.ok(
                brandService.queryBrandByPage(current,pageSize,sortBy,desc,key)
        );
    }
    /*
    * 新增品牌
    * @params
    * */
    @PostMapping("/saveBrand")
    public ResponseEntity<Void> saveBrand(@RequestBody JSONObject jsonParam){
        Brand brand = JSONObject.toJavaObject(jsonParam, Brand.class);
        List<Long> cids = new ArrayList<>();
        String cidsStr = (String) jsonParam.get("cids");
        if(StringUtils.contains(cidsStr,",")){
            String[] split = StringUtils.split(",");
            for(int i=0;i<split.length;i++){
                cids.add(Long.parseLong(split[i])) ;
            }
        }else{
            cids.add(Long.parseLong(cidsStr));
        }
        brandService.saveBrand(brand,cids);
        // 新增成功的响应体;
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

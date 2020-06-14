package com.leyou.item.mapper;

import com.leyou.item.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface BrandMapper extends Mapper<Brand> {
    // 商品分类 商品品牌中间表
    @Insert("INSERT INTO tb_category_brand(category_id,brand_id) values(#{cid},#{bid})")
    int insertCategoryBrand(@Param("cid") Long cid,@Param("bid") Long bid);
}

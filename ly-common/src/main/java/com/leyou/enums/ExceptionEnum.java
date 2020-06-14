package com.leyou.enums;/*
 *@params com.leyou.enums
 *@description 自定义异常信息枚举类
 *@auth huchongyuan
 *@create 2020-05-01 09:
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {
    PRICE_CANNOT_BE_NULL(400,"价格不能为空!"),
    CATEGORY_NOT_FOUND(404,"商品分类没有查到"),
    BRAND_NOT_FOUND(404,"商品品牌没有找到"),
    BRAND_SAVE_ERROR(500,"服务器新增品牌失败"),
    BRAND_CATEGORY_SAVE_ERROR(500,"品牌类别关系新增异常"),
    FILE_UPLOAD_ERROR(500,"文件上传失败"),
    FILE_TYPE_NOT_ALLOW(500,"无效的文件类型"),
    SPEC_GROUP_NOT_FOUND(299,"当前组没有数据")
    ;
    private int code;
    private String msg;

}

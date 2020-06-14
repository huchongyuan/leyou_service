package com.leyou.vo;/*
 *@params com.leyou.vo
 *@description 异常结果对象
 *@auth huchongyuan
 *@create 2020-05-01 09:
 */

import com.leyou.enums.ExceptionEnum;
import lombok.Data;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum em) {
        this.status=em.getCode();
        this.message = em.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}

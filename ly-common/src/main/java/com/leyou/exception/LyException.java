package com.leyou.exception;
/*
 *@params com.leyou.exception
 *@description 自定义异常,继承Exception
 *@auth huchongyuan
 *@create 2020-05-01 09:
 */

import com.leyou.enums.ExceptionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class LyException extends RuntimeException {
    private ExceptionEnum enums;
}

package com.leyou.advice;/*
 *@params com.leyou.advice
 *@description  controller 通用的异常处理,默认拦截@Controller注解的类  引入springmvc的依赖
 *@auth huchongyuan
 *@create 2020-05-01 09:
 */

import com.leyou.enums.ExceptionEnum;
import com.leyou.exception.LyException;
import com.leyou.vo.ExceptionResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
    // 拦截指定的异常。controller 统一抛LyException 自定义异常
    @ExceptionHandler(LyException.class)
    public ResponseEntity<ExceptionResult> handleException(LyException ex){
        ExceptionEnum enums = ex.getEnums();
        return ResponseEntity.status(enums.getCode()).body(new ExceptionResult(enums));
    }
}

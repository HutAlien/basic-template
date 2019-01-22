package com.alien.basicTemplate.exception;

import com.alien.basicTemplate.model.dto.AjaxCode;
import com.alien.basicTemplate.model.dto.AjaxResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 14:51
 * @Description:
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理自定义异常
     *
     * @param
     * @return
     */
    @ExceptionHandler(CustomException.class)
    public AjaxResult handleCustomException(CustomException e){
        return new AjaxResult(AjaxCode.FAILURE,e.getMessage());
    }
}

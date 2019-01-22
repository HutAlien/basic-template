package com.alien.basicTemplate.model.dto;

import lombok.Data;

/**
 * @Auther: FengYunJun
 * @Date: 2018/11/23 10:31
 * @Description:
 */
@Data
public class AjaxResult {
    private Integer Code;
    private String message;
    private Object data;
    private Integer total;

    public AjaxResult() {
    }

    public AjaxResult(Integer code, String message) {
        Code = code;
        this.message = message;
    }

    public AjaxResult(Integer code, String message, Object data) {
        Code = code;
        this.message = message;
        this.data = data;
    }

    public AjaxResult(Integer code, String message, Object data, Integer total) {
        Code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }
}

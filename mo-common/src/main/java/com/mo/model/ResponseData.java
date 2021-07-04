package com.mo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mo.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by mo on 2021/7/2
 * 数据返回封装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

    /**
     * 返回状态码 0 表示成功，1表示处理中，-1表示失败
     */
    private Integer code;
    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回的数据
     */
    private Object data;


    /**
     * 成功，传入数据
     *
     * @param data
     * @return
     */
    public static ResponseData buildSuccess(Object data) {
        return new ResponseData(0, null, data);
    }

    /**
     * 成功，传入状态码、操作信息、数据
     *
     * @param data
     * @param resultEnum
     * @return
     */
    public static ResponseData buildSuccess(Object data, ResultEnum resultEnum) {
        return new ResponseData(resultEnum.getCode(), resultEnum.getMessage(), data);
    }

    /**
     * 失败，传入描述信息
     *
     * @param msg
     * @return
     */
    public static ResponseData buildError(String msg) {
        return new ResponseData(-1, msg, null);
    }


    /**
     * 自定义状态码和错误信息
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResponseData buildCodeAndMsg(int code, String msg) {
        return new ResponseData(code, msg, null);
    }

    /**
     * 传入枚举，返回信息
     *
     * @param codeEnum
     * @return
     */
    public static ResponseData buildResult(ResultEnum codeEnum) {
        return ResponseData.buildCodeAndMsg(codeEnum.getCode(), codeEnum.getMessage());
    }


}

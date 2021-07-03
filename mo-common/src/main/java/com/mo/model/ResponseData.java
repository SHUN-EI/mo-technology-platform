package com.mo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by mo on 2021/7/2
 * 数据返回封装类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResponseData<T> {

    /**
     * 返回状态码
     */
    private String code;
    /**
     * 返回信息
     */
    private String desc;
    /**
     * 返回的数据
     */
    private T data;
    /**
     * 返回数据总数
     */
    private Integer count;

}

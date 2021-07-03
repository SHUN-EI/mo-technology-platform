package com.mo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by mo on 2021/7/2
 */
//如果加该注解的字段为null,那么就不序列化
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class CommonEntity {

    /**
     * 页码
     */
    private int pageNumber;
    /**
     * 每页数据条数
     */
    private int pageSize;
    /**
     * 索引名称
     */
    private String indexName;
    /**
     * 高亮列
     */
    private String highlight;
    /**
     * 排序 DESC  ASC
     */
    private String sortOrder;
    /**
     * 排序列
     */
    private String sortField;
    /**
     * 自动补全建议列
     */
    private String suggestFileld;
    /**
     * 自动补全建议值
     */
    private String suggestValue;
    /**
     * 自动补全返回个数
     */
    private Integer suggestCount;
    /**
     * 动态查询参数封装
     */
    private Map<String, Object> map;
    /**
     * 批量增加list
     */
    private List<Map<String, Object>> list;

}

package com.mo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by mo on 2021/7/2
 * 通用请求对象
 */
@Data
public class CommonRequest {

    /**
     * 页码
     */
    @JsonProperty("page_number")
    private int pageNumber;
    /**
     * 每页数据条数
     */
    @JsonProperty("page_size")
    private int pageSize;
    /**
     * 索引名称
     */
    @JsonProperty("index_name")
    private String indexName;
    /**
     * 高亮列
     */
    private String highlight;
    /**
     * 排序 DESC  ASC
     */
    @JsonProperty("sort_order")
    private String sortOrder;
    /**
     * 排序列
     */
    @JsonProperty("sort_field")
    private String sortField;
    /**
     * 自动补全建议列
     */
    @JsonProperty("suggest_fileld")
    private String suggestFileld;
    /**
     * 自动补全建议值
     */
    @JsonProperty("suggest_value")
    private String suggestValue;
    /**
     * 自动补全返回个数
     */
    @JsonProperty("suggest_count")
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

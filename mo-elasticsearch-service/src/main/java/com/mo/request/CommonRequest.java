package com.mo.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by mo on 2021/7/2
 * 通用请求对象
 */
@ApiModel(value = "通用请求对象", description = "通用请求对象")
@Data
public class CommonRequest {

    @ApiModelProperty(value = "页码")
    @JsonProperty("page_number")
    private int pageNumber;

    @ApiModelProperty(value = "每页数据条数")
    @JsonProperty("page_size")
    private int pageSize;

    @ApiModelProperty(value = "索引名称")
    @JsonProperty("index_name")
    private String indexName;

    @ApiModelProperty(value = "高亮列")
    private String highlight;

    @ApiModelProperty(value = "排序(DESC/ASC)")
    @JsonProperty("sort_order")
    private String sortOrder;

    @ApiModelProperty(value = "排序列")
    @JsonProperty("sort_field")
    private String sortField;

    @ApiModelProperty(value = "自动补全建议列")
    @JsonProperty("suggest_fileld")
    private String suggestFileld;

    @ApiModelProperty(value = "自动补全建议值")
    @JsonProperty("suggest_value")
    private String suggestValue;

    @ApiModelProperty(value = "自动补全返回个数")
    @JsonProperty("suggest_count")
    private Integer suggestCount;

    @ApiModelProperty(value = "动态查询参数封装")
    private Map<String, Object> map;

    @ApiModelProperty(value = "批量增加list")
    private List<Map<String, Object>> list;
}

package com.mo.enums;

import lombok.Getter;

/**
 * CREATEd by mo on 2021/7/4
 * 枚举类，统一状态码和错误信息
 */
public enum ResultEnum {

    SUCCESS(200, "操作成功！"),
    PARAM_ISNULL(400, "参数为空"),
    ERROR(402, "操作失败！"),
    SERVER_ERROR(500, "服务异常"),
    DATA_NOT_EXIST(504, "数据不存在"),
    RESULT_EMPTY(000, "查询内容为空"),

    NOT_SYSTEM_API(404, "不是系统指定api"),
    REPEAT(666, "数据已存在"),
    HTTP_ERROR(405, "请求异常"),


    /**
     * 索引
     */
    CREATE_INDEX_SUCCESS(300001, "创建索引成功！"),
    CREATE_INDEX_FAIL(300002, "创建索引失败！"),
    DELETE_INDEX_SUCCESS(300003, "删除索引成功！"),
    DELETE_INDEX_FAIL(300004, "删除索引失败！"),
    OPEN_INDEX_SUCCESS(300005, "打开索引成功！"),
    OPEN_INDEX_FAIL(300006, "打开索引失败！"),
    CLOSE_INDEX_SUCCESS(300007, "关闭索引成功！"),
    CLOSE_INDEX_FAIL(300008, "关闭索引失败！"),
    ALIAS_INDEX_SUCCESS(300009, "索引别名设置成功！"),
    ALIAS_INDEX_FAIL(300010, "索引别名设置失败！"),
    EXISTS_INDEX_SUCCESS(300011, "索引是否存在查询成功！"),
    EXISTS_INDEX_FAIL(300012, "索引是否存在查询失败！"),
    INDEX_DEFAULT(300013, "索引创建失败！"),

    /**
     * 文档
     */
    CREATE_DOC_SUCCESS(400001, "创建文档成功！"),
    CREATE_DOC_FAIL(400002, "创建文档失败！"),
    BATCH_CREATE_DOC_SUCCESS(400003, "批量创建文档成功！"),
    BATCH_CREATE_DOC_FAIL(400004, "批量创建文档失败！"),
    UPDATE_DOC_SUCCESS(400005, "修改文档成功！"),
    UPDATE_DOC_FAIL(400006, "修改文档失败！"),
    GET_DOC_SUCCESS(400007, "查询文档成功！"),
    BATCH_GET_DOC_FAIL(400008, "批量查询文档失败！"),
    BATCH_GET_DOC_SUCCESS(400009, "批量查询文档成功！"),
    GET_DOC_FAIL(400010, "查询文档失败！"),
    DELETE_DOC_SUCCESS(400011, "删除文档成功！"),
    DELETE_DOC_FAIL(400012, "删除文档失败！"),
    CSUGGEST_GET_DOC_FAIL(400013, "自动补全获取失败！"),
    CSUGGEST_GET_DOC_SUCCESS(400014, "自动补全获取成功！"),

    PSUGGEST_GET_DOC_FAIL(500001, "拼写纠错获取失败！"),
    PSUGGEST_GET_DOC_SUCCESS(500002, "拼写纠错获取成功！"),

    TSUGGEST_GET_DOC_FAIL(600001, "搜索推荐获取失败！"),
    TSUGGEST_GET_DOC_SUCCESS(600002, "搜索推荐获取成功！"),

    HOTWORDS_GET_DOC_FAIL(700001, "搜索热词获取失败！"),
    HOTWORDS_GET_DOC_SUCCESS(700002, "搜索热词获取成功！"),
    METRICAGG_GET_DOC_FAIL(700003, "指标聚合处理失败！"),
    METRICAGG_GET_DOC_SUCCESS(700004, "指标聚合处理成功！"),

    BUCKETAGG_GET_DOC_FAIL(800001, "桶聚合处理失败！"),
    BUCKETAGG_GET_DOC_SUCCESS(800002, "桶聚合处理成功！");


    @Getter
    private int code;

    @Getter
    private String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

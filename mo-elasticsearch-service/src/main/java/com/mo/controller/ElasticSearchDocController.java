package com.mo.controller;

import com.mo.model.ResponseData;
import com.mo.request.CommonRequest;
import com.mo.service.ElasticSearchDocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mo on 2021/7/2
 */
@Api(tags = "搜索模块")
@RestController
@RequestMapping("/api/doc/v1")
public class ElasticSearchDocController {

    @Autowired
    private ElasticSearchDocumentService elasticSearchDocumentService;

    /**
     * 全文检索
     *
     * @return
     */
    @ApiOperation("全文检索")
    @GetMapping("/matchQuery")
    public ResponseData matchQuery(@RequestBody CommonRequest request) {

        return elasticSearchDocumentService.matchQuery(request);

    }
}

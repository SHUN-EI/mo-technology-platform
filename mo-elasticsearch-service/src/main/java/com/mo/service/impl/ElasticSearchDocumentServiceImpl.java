package com.mo.service.impl;

import com.mo.model.CommonEntity;
import com.mo.model.ResponseData;
import com.mo.request.CommonRequest;
import com.mo.service.ElasticSearchDocumentService;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mo on 2021/7/2
 */
@Service
public class ElasticSearchDocumentServiceImpl implements ElasticSearchDocumentService {

    @Autowired
    private RestHighLevelClient client;

    /**
     * 全文检索
     *
     * @param request
     * @return
     */
    @Override
    public ResponseData matchQuery(CommonRequest request) {

        //构建查询响应
        SearchResponse response = null;
        //构建查询请求
        SearchRequest searchRequest = new SearchRequest(request.getIndexName());
        //构建DSL请求体
        SearchSourceBuilder builder = new SearchSourceBuilder().trackTotalHits(true);
        //获取前端查询条件
        getClientConditions(request, builder);

        return null;
    }

    /**
     * 获取前端查询条件
     *
     * @param request
     * @param builder
     */
    private void getClientConditions(CommonRequest request, SearchSourceBuilder builder) {
    }
}

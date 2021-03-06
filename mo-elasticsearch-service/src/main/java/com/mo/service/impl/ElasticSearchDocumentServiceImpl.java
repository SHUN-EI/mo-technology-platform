package com.mo.service.impl;

import com.mo.enums.ResultEnum;
import com.mo.model.CommonEntity;
import com.mo.model.ResponseData;
import com.mo.request.CommonRequest;
import com.mo.service.ElasticSearchDocumentService;
import com.mo.utils.SearchUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
        SearchResponse result = null;
        //构建查询请求
        SearchRequest searchRequest = new SearchRequest(request.getIndexName());
        //构建DSL请求体
        SearchSourceBuilder builder = new SearchSourceBuilder().trackTotalHits(true);
        //获取前端查询条件
        getClientConditions(request, builder);
        //高亮设置
        builder.highlighter(SearchUtil.getHighlightBuilder(request.getHighlight()));
        //前端页码
        int pageNumber = request.getPageNumber();
        //前端每页数据条数
        int pageSize = request.getPageSize();
        //计算查询的下标
        int dest = (pageNumber - 1) * pageSize;
        builder.from(dest);
        builder.size(pageSize);//每页数量
        //将查询条件放到请求对象中
        searchRequest.source(builder);

        try {
            //执行远程查询
            //调用全文检索方法
            result = client.search(searchRequest, RequestOptions.DEFAULT);
            //获取数据个数
            long size = result.getHits().getTotalHits().value;
            //处理高亮
            SearchUtil.setHighResultForCleintUI(result, request.getHighlight());

            Map<String, Object> pageMap = new HashMap<>();
            //总条数
            pageMap.put("total_record", size);
            pageMap.put("current_data", result);

            return ResponseData.buildSuccess(pageMap, ResultEnum.SUCCESS);

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseData.buildResult(ResultEnum.ERROR);
        }
    }

    /**
     * 获取前端查询条件
     *
     * @param request
     * @param builder
     */
    private void getClientConditions(CommonRequest request, SearchSourceBuilder builder) {

        Map<String, Object> requestMap = request.getRequestMap();
        if (requestMap != null) {
            requestMap.forEach((k, v) ->
                    //查询请求体query
                    builder.query(QueryBuilders.matchQuery(k, v))
            );
        }

    }
}

package com.mo.service;

import com.mo.model.CommonEntity;
import com.mo.model.ResponseData;
import com.mo.request.CommonRequest;
import org.elasticsearch.action.search.SearchResponse;

/**
 * Created by mo on 2021/7/2
 */
public interface ElasticSearchDocumentService {

    /**
     * 全文检索
     *
     * @param request
     * @return
     */
    ResponseData matchQuery(CommonRequest request);
}

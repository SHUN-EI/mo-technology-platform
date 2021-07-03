package com.mo.utils;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;

import java.util.Map;

/**
 * Created by mo on 2021/7/3
 * 搜索工具类
 */
public class SearchUtil {

    /**
     * 获取高亮构建器
     * 设置高亮,使用默认的highlighter高亮器,默认em斜体
     *
     * @param highlightField
     * @return
     */
    public static HighlightBuilder getHighlightBuilder(String highlightField) {

        //生成高亮查询器
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        //高亮查询字段
        highlightBuilder.field(highlightField);
        //如果要多个字段高亮,这项要为false
        highlightBuilder.requireFieldMatch(false);
        //自定义-高亮设置
        highlightBuilder.preTags("<span style= " +
                "color:red;font-weight:bold;font-size:15px;" + ">");
        highlightBuilder.postTags("</span>");
        //下面这两项,如果你要高亮,如文字内容等有很多字的字段,必须配置,不然会导致高亮不全,文章内容缺失等
        //设置最大高亮分片数
        highlightBuilder.fragmentSize(800000);
        //从第一个分片获取高亮片段
        highlightBuilder.numOfFragments(0);
        return highlightBuilder;
    }

    /**
     * 高亮前端显示组装，SearchResponse传递引用
     *
     * @param response
     * @param highlightField
     */
    public static void setHighResultForCleintUI(SearchResponse response, String highlightField) {

        if (StringUtils.isNotEmpty(highlightField)) {
            response.getHits().forEach(obj -> {
                //获取高亮字段map
                Map<String, HighlightField> highlightFields = obj.getHighlightFields();
                //获取到具体的高亮列
                HighlightField highlightFieldName = highlightFields.get(highlightField);

                //getSourceAsMap拿到具体的数据
                Map<String, Object> source = obj.getSourceAsMap();
                if (highlightFieldName != null) {
                    //获取渲染后的文本
                    Text[] fragments = highlightFieldName.fragments();
                    String name = "";
                    for (Text text : fragments) {
                        name += text;
                    }
                    //高亮字段替换掉原本的内容
                    source.put(highlightField, name);
                }
            });
        }
    }

}

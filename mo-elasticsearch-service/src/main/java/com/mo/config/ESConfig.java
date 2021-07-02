package com.mo.config;

import lombok.Data;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by mo on 2021/7/2
 */
@Configuration
@ConfigurationProperties(prefix = "elasticsearch")
@Data
public class ESConfig {

    //es集群ip
    private String clusterHost;
    //es集群节点一端口
    private Integer esNode1Port;
    //es集群节点二端口
    private Integer esNode2Port;
    //es集群节点三端口
    private Integer esNode3Port;
    //设置超时时间为5分钟
    private static final int TIMEOUT = 5 * 60 * 1000;

    /**
     * es客户端实例的构建器
     *
     * @return
     */
    @Bean
    public RestClientBuilder restClientBuilder() {

        return RestClient.builder(new HttpHost(clusterHost, esNode1Port, "http"),
                new HttpHost(clusterHost, esNode2Port, "http"),
                new HttpHost(clusterHost, esNode3Port, "http"));
    }

    /**
     * es高阶客户端连接实例
     * Spring容器关闭后，bean对象销毁
     * @param restClientBuilder
     * @return
     */
    @Bean(destroyMethod = "close")
    public RestHighLevelClient highLevelClient(@Autowired RestClientBuilder restClientBuilder) {

        restClientBuilder.setRequestConfigCallback(
                builder -> builder.setSocketTimeout(TIMEOUT)
        );

        return new RestHighLevelClient(restClientBuilder);
    }


}

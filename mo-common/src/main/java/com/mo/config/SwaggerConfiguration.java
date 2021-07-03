package com.mo.config;

import io.swagger.models.HttpMethod;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import springfox.documentation.builders.*;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mo on 2021/7/3
 */
@Component
@Data
@EnableOpenApi
public class SwaggerConfiguration {

    /**
     * C端-用户相关
     *
     * @return
     */
    @Bean
    public Docket webApiDoc() {

        return new Docket(DocumentationType.OAS_30)
                .groupName("终极搜索平台接口文档")
                .pathMapping("/")
                //定义是否开启swagger，false为关闭，可以通过变量控制，线上关闭
                .enable(true)
                //配置api文档元信息
                .apiInfo(apiInfo())
                //选择哪些接口作为swagger的doc发布
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mo"))
                //正则匹配请求路径，并分配至当前分组
                .paths(PathSelectors.ant("/api/**"))
                //正则匹配请求路径，并分配至当前分组，当前所有接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("终极搜索平台")
                .description("终极搜索平台接口文档")
                .contact(new Contact("mo", "waynemo.top", "295597613@qq.com"))
                .version("v1.0")
                .build();
    }
}

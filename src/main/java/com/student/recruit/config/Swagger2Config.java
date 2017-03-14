package com.student.recruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger2 配置类.
 * Created by xiachao on 2017/3/9.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


  /*@Bean
  public Docket testApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("test")
        .genericModelSubstitutes(DeferredResult.class)
//      .genericModelSubstitutes(ResponseEntity.class)
        .useDefaultResponseMessages(false)
        .forCodeGeneration(true)
        .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
        .select()
        .paths(or(regex("/api/.*")))//过滤的接口
        .build()
        .apiInfo(testApiInfo());
  }

  @Bean
  public Docket demoApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("api")
        .genericModelSubstitutes(DeferredResult.class)
//              .genericModelSubstitutes(ResponseEntity.class)
        .useDefaultResponseMessages(false)
        .forCodeGeneration(false)
        .pathMapping("/")
        .select()
        .paths(or(regex("/api/.*")))//过滤的接口
        .build()
        .apiInfo(demoApiInfo());
  }

  private ApiInfo testApiInfo() {
    return new ApiInfoBuilder()
        .title("Electronic Health Record(EHR) Platform API")//大标题
        .description("EHR Platform's REST API, all the applications could access the Object model data via JSON.")//详细描述
        .version("1.0")//版本
        .termsOfServiceUrl("NO terms of service")
        .contact(new Contact("小单", "http://blog.csdn.net/catoop", "365384722@qq.com"))//作者
        .license("The Apache License, Version 2.0")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
        .build();
  }

  private ApiInfo demoApiInfo() {
    return new ApiInfoBuilder()
        .title("Electronic Health Record(EHR) Platform API")//大标题
        .description("EHR Platform's REST API, all the applications could access the Object model data via JSON.")//详细描述
        .version("1.0")//版本
        .termsOfServiceUrl("NO terms of service")
        .contact(new Contact("小单", "http://blog.csdn.net/catoop", "365384722@qq.com"))//作者
        .license("The Apache License, Version 2.0")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
        .build();
  }*/


  public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.student.recruit.controller";
  public static final String VERSION = "1.0.0";

  ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("迷你校api文档")
        .description("SAAS系统公司设置，职位，候选人等相关接口说明")
        .license("Apache 2.0")
        .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
        .termsOfServiceUrl("")
        .version(VERSION)
        .contact(new Contact("", "", "xiachaosir@163.com"))
        .build();
  }

  @Bean
  public Docket customImplementation() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
        .paths(PathSelectors.any())
        .build();
  }
}

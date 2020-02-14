package com.wenl.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {
    //配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示的swagger环境
        Profiles profiles = Profiles.of("dev","test");//可多环境  以上环境开启swagger
        //通过environment.acceptsProfiles判断是否在设定环境中来启动swagger
        //eg：测试环境 启动 swagger 上线则不启动
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)//是否启动Swagger f swagger 不能浏览
                .select()
                //RequestHandlerSelectors 配置需要扫描接口的方式
                //      basePackage指定要扫描的包
                //      any();扫描全部
                //      none();都不扫描
                //      withClassAnnotation(XXX.clsss);//扫描XXX类上的注解 eg：RestContorller.class 类上的
                //      withMethodAnnotation();扫描方法上的注解  eg：GetMapping.class
                .apis(RequestHandlerSelectors.basePackage("com.wenl.swagger.controller"))
                //paths()过滤什么路径
                //.paths(PathSelectors.ant(""))
                .build();
    }

    //配置Swagger信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("wenl","https://github.com/wenl125539/SwaggerDemo","1255391360@qq.com");

        return new ApiInfo(
                "学习SwaggerApi文档",
                "SwaggerApi描述",
                "v1.0",
                "http://localhost:8080",
                contact,        //作者信息
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}

package com.frank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@Profile("dev")
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket orderApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("order-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/order/*"))
                .build()
                .apiInfo(orderApiInfo());
    }

    private ApiInfo orderApiInfo() {
        return new ApiInfo(
                "Order API",
                "This is a demo order API.",
                "V1",
                "Terms of service",
                new Contact("Frank Xie", "www.frank.com", "frank@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    @Bean
    public Docket priceApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("price-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/price/.*"))
                .build()
                .apiInfo(priceApiInfo());
    }

    private ApiInfo priceApiInfo() {
        return new ApiInfo(
                "Price API",
                "This is a demo price API.",
                "V1",
                "Terms of service",
                new Contact("Frank Xie", "www.frank.com", "frank@company.com"),
                "License of API", "API license URL", Collections.emptyList());
    }

    // http://localhost:8080/swagger-ui.html
    // RequestHandlerSelectors.basePackage("com.frank")
    // PathSelectors: any(), none(), regex(), or ant()
}

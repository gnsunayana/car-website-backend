package com.udacity.vehicles.api;


import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ApiResponses(value = {
        @ApiResponse(code = 400, message = "This is a bad request,please follow the API Documentation for the same"),
        @ApiResponse(code = 401, message = "Due to security constraints, your access request can not be authorised"),
        @ApiResponse(code = 500, message = "The server is down.Please make sure that the Vehicles microservices in up and running")
})
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();

    }
}

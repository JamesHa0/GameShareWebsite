package com.game.web.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.headers.Header;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static final String BEARER_TOKEN = "Bearer eyJ0eXBlIjoiSldUIiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiIxIiwiaWF0IjoxNzMxODM5OTUyLCJleHAiOjE3MzI0NDQ3NTIsInVuYW1lIjoicm9vdCIsImF1dGhvcml0aWVzIjoiW1JPTEVfQURNSU4sIGxvZ2luOmxvZ2luLCBsb2dpbjp0b0xvZ2luLCBsb2dvdXQsIHJlZzpyZWdpc3RlciwgcmVnOnRvUmVnaXN0ZXIsIHVzZXI6YWRkLCB1c2VyOmxpc3QsIHVzZXI6bWFuYWdlciwgdXNlcjptb2RpZnksIHVzZXI6cmVtb3ZlLCB1c2VyOnRvQWRkLCB1c2VyOnRvTW9kaWZ5XSJ9.fyo79kAz1Alw33lmId8vifRCkQzPr-mwyb_sSaDxdRE";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Game Framework API").version("1.0").description("API for Game Framework"))
            .addSecurityItem(new SecurityRequirement().addList("bearerAuth"))
            .components(new io.swagger.v3.oas.models.Components()
                .addSecuritySchemes("bearerAuth", new SecurityScheme()
                    .name(AUTHORIZATION_HEADER)
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT"))
                .addHeaders(AUTHORIZATION_HEADER, new Header().description("Bearer Token").required(true).example(BEARER_TOKEN)));
    }
//
//    @Bean
//    public GroupedOpenApi apiGroup() {
//        return GroupedOpenApi.builder()
//            .group("game-framework")
//            .addOpenApiCustomiser(this::applyGlobalAuthorization)
//            .pathsToMatch("/**")
//            .build();
//    }
//
//    private void applyGlobalAuthorization(OpenAPI openApi) {
//        openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> {
//            operation.addParametersItem(new io.swagger.v3.oas.models.parameters.HeaderParameter()
//                .name(AUTHORIZATION_HEADER)
//                .required(true)
//                .example(BEARER_TOKEN)
//                .description("Bearer Token for JWT authentication"));
//        }));
//    }
}

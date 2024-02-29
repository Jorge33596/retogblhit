package com.retogblhit.retogblhit;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;
import com.retogblhit.retogblhit.dto.EstadoRespuesta;

import lombok.RequiredArgsConstructor;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

	private final TypeResolver resolver;
    public static final Contact DEFAULT_CONTACT = new Contact(
            "Reto técnico CLARO",
            "",
            ""
    );
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Mediapp Api Documentation",
            "Mediapp Api Documentation",
            "1.0",
            "PREMIUM",
            DEFAULT_CONTACT,
            "Apache 2.0",
            "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<>()
    );

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(DEFAULT_API_INFO)
                //.securityContexts(Collections.singletonList(securityContext()))
                //.securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .additionalModels(resolver.resolve(EstadoRespuesta.class));
    }
}

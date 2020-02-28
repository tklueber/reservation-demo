package ch.baloise.klueber.reservationdemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("ch.baloise.klueber.reservationdemo.webservice"))
                .paths(PathSelectors.any())
                .build().apiInfo(this.apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Reservation API",
                "demoproject",
                "1.0.0",
                "Terms of service",
                new Contact("Timo Klüber", "www.klueber.email", "timo@klueber.email"),
                "License of API", "API license URL", Collections.emptyList());
    }
}

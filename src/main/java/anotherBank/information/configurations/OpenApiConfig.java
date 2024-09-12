package anotherBank.information.configurations;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SecurityScheme(
        name = "Api-Key",
        description = "API Key Authentication",
        type = SecuritySchemeType.APIKEY,
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {

    @Value("${spring.application.openApi.description}")
    private String appDescription;
    @Value("${spring.application.openApi.version}")
    private String appVersion;
    @Value("${spring.application.openApi.title}")
    private String appTitle;
    @Value("${spring.application.openApi.license.name}")
    private String appLicense;
    @Value("${spring.application.openApi.license.url}")
    private String appLicenseUrl;


    @Bean
    public OpenAPI customOpenAPI() {

        return new OpenAPI()
                .info(new Info()
                        .title(appTitle)
                        .version(appVersion)
                        .description(appDescription)
                        .license(new License().name(appLicense).url(appLicenseUrl)));

    }
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("api v1")
                .pathsToMatch("/api/v1/**")
                .build();
    }
}

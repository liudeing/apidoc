package my.rest.controller.apiconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger springmvc
 * Created by Ldp on 2017/6/13.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

    @Value("${apidoc}")
    private boolean apidoc;

    @Bean
    public Docket v320() {
        return apiVersion(ApiConfiguration.Version.v320);
    }

    @Bean
    public Docket v110() {
        return apiVersion(ApiConfiguration.Version.v110);
    }

    @Bean
    public Docket base() {
        return apiVersion(ApiConfiguration.Version.base);
    }

    public Docket apiVersion(ApiConfiguration.Version version) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(
                        new ApiInfo(version._description() + " —— WebApi在线文档|测试工具",
                                version._description(), null,
                                null, null, null, null, null)
                )

                .enable(apidoc)

                .groupName(version._name())
                .select()  // 选择那些路径和api会生成document
                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
                .paths(PathSelectors.any()) // 对所有路径进行监控
                .build();

    }
}

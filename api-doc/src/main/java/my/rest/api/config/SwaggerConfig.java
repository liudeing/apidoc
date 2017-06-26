package my.rest.api.config;

import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * api doc -- springfox swagger configuration
 * Created by Ldp on 2017/6/13.
 */
@Configuration
@EnableWebMvc
@EnableSwagger2
public class SwaggerConfig {

    @Value("${apidoc}")
    private boolean apidoc;

    @Value("${spring.jersey.application-path:/api}")
    private String apiPath;

    @Bean
    public SecurityScheme apiKey() {
        return new ApiKey("access_token", "accessToken", "header");
    }

    @Bean
    public Docket apiConfig() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("controller")
                // 调用apiInfo方法,创建一个ApiInfo实例,里面是展示在文档页面信息内容
                .apiInfo(apiInfo()).select()
                // 控制暴露出去的路径下的实例
                // 如果某个接口不想暴露,可以使用以下注解
                // @ApiIgnore 这样,该接口就不会暴露在 swagger2 的页面下
                .apis(RequestHandlerSelectors.basePackage("my.rest.api.controller")).paths(PathSelectors.any())
                .build().useDefaultResponseMessages(false).securitySchemes(Arrays.asList(apiKey()));
    }

    @Bean
    public Docket restConfig() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("jax-rs").apiInfo(restInfo()).forCodeGeneration(true)
                .pathMapping("/").select().paths(paths())// 过滤的接口
                .build().useDefaultResponseMessages(false);
    }

    // 请求url匹配，支持and or，可以过滤筛选
    private Predicate<String> paths() {
        return or(regex("/test/.*"), regex("/rest/.*")); //
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("berheley service controller api ")// 大标题
                .description("spring boot webservice 平台 API")// 小标题
                // .termsOfServiceUrl("http://ww.swagger.com/")
                // .contact(new Contact("swagger", "www.swagger.com",
                // "swagger@foxmail.com"))
                .version("2.0").build();
    }

    private ApiInfo restInfo() {
        return new ApiInfoBuilder().title("berheley service rest api ")// 大标题
                .description("spring boot webservice 平台 API")// 小标题
                .version("2.0").build();
    }

//    @Bean
//    public Docket v320() {
//        return apiVersion(ApiConfiguration.Version.v320);
//    }
//
//    @Bean
//    public Docket v110() {
//        return apiVersion(ApiConfiguration.Version.v110);
//    }
//
//    @Bean
//    public Docket base() {
//        return apiVersion(ApiConfiguration.Version.base);
//    }
//
//    public Docket apiVersion(ApiConfiguration.Version version) {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(
//                        new ApiInfo(version._description() + " —— WebApi在线文档|测试工具",
//                                version._description(), null,
//                                null, null, null, null)
//                )
//
//                .enable(apidoc)
//
//                .groupName(version._name())
//                .select()  // 选择那些路径和api会生成document
//                .apis(RequestHandlerSelectors.any()) // 对所有api进行监控
//                .paths(PathSelectors.any()) // 对所有路径进行监控
//                .build();
//
//    }
}

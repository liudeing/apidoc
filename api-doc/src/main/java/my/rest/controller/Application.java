package my.rest.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

/**
 * Created by Ldp on 2017/6/13.
 */
@EnableAutoConfiguration
@SpringBootConfiguration
public class Application extends SpringBootServletInitializer {
    @Override
    public SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class, args);
        String[] envProfile = context.getEnvironment().getActiveProfiles();

        for (String env : envProfile) {
            System.out.println("current profile is= " + env);
        }

    }
}

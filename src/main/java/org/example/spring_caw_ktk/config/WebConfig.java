package org.example.spring_caw_ktk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // /static/ 이하 경로를 /static/ 내부 파일로 매핑
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");

        registry.addResourceHandler("/img/**")
                .addResourceLocations("classpath:/static/images/");

        registry.addResourceHandler("/js/**")
                .addResourceLocations("classpath:/static/js/");
    }
}

package com.ibrahim.spring.lesson06.task02_request_parsing_and_validation;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class WebConfig  implements WebMvcConfigurer {
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        PathPatternParser parser = new PathPatternParser();
        configurer.setPatternParser(parser);
    }
}

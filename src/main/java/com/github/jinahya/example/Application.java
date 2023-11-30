package com.github.jinahya.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@ConfigurationPropertiesScan(
        basePackageClasses = {
                com.github.jinahya.juso.go.kr.api.proxy._NoOp.class
        }
)
@ComponentScan(
        basePackageClasses = {
                com.github.jinahya.juso.go.kr.api.proxy._NoOp.class
        }
)
@SpringBootApplication
class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }
}

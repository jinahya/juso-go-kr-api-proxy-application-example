package com.github.jinahya.example;

import com.github.jinahya.juso.go.kr.api.proxy._NoOp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;

@ConfigurationPropertiesScan(
        basePackageClasses = {
                _NoOp.class
        }
)
@ComponentScan(
        basePackageClasses = {
                _NoOp.class
        }
)
@SpringBootApplication
class Application {

    public static void main(final String... args) {
        org.springframework.boot.SpringApplication.run(Application.class, args);
    }
}

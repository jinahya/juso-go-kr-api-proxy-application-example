package com.github.jinahya.example;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.jinahya.juso.go.kr.api.proxy._NoOp;
import com.github.jinahya.juso.go.kr.api.proxy.stereotype.AddrRetrievalEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

import java.util.concurrent.TimeUnit;

@EnableCaching
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
@Slf4j
class Application {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CacheManager cacheManager() {
        final var cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(60, TimeUnit.MINUTES));
        cacheManager.setAsyncCacheMode(true);
        return cacheManager;
    }

    @EventListener
    void retrieved(final AddrRetrievalEvent<?, ?> event) {
        log.debug("retrieved: {}", event);
    }
}

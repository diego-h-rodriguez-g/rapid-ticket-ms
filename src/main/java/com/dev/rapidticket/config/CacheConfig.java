package com.dev.rapidticket.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager seatsCache = new CaffeineCacheManager("SectorSeatResponse");
        seatsCache.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(30, TimeUnit.SECONDS));

        CaffeineCacheManager anotherCache = new CaffeineCacheManager("JavaStackResponse");
        anotherCache.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(2, TimeUnit.MINUTES));

        return new CompositeCacheManager(seatsCache, anotherCache);
    }
}

package com.key.value.store.config;

import com.key.value.store.util.Constants;
import com.key.value.store.util.IOUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.*;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
@Slf4j
public class CacheConfig {
    /*
        Since beans are initialized during service startup, the cacheMap will be loaded from the FILE and then injected
        into KVCache.
     */
    @Bean
    public ConcurrentHashMap<String,String> cacheMap() {
        ConcurrentHashMap<String,String> cache = new ConcurrentHashMap<>();
        IOUtils.readFileAndUpdateCache(Constants.FILE_NAME, cache);
        return cache;
    }
}

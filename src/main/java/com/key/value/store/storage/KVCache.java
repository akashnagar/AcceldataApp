package com.key.value.store.storage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ConcurrentHashMap;

@Component
@RequiredArgsConstructor
public class KVCache implements Cache{

    private final ConcurrentHashMap<String,String> cacheMap;

    @Override
    public void upsert(String key, String value) {
        cacheMap.put(key, value);
    }

    @Override
    public void delete(String key) {
        cacheMap.remove(key);
    }

    @Override
    public String get(String key) {
        return cacheMap.get(key);
    }

    @Override
    public boolean containsKey(String key) {
        return cacheMap.containsKey(key);
    }
}

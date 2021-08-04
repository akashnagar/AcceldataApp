package com.key.value.store.service;

import com.key.value.store.storage.Cache;
import com.key.value.store.storage.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{

    private final Cache cache;
    private final Storage storage;

    @Override
    public void upsert(String key, String value) {
        cache.upsert(key, value);
        storage.upsert(key, value);
    }

    @Override
    public String get(String key) {
        return cache.get(key);
    }

    @Override
    public void delete(String key) {
        if (cache.containsKey(key)){
            cache.delete(key);
            storage.delete(key);
        }
    }
}

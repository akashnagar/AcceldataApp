package com.key.value.store.service;

public interface StoreService {
    void upsert(String key, String value);
    String get(String key);
    void delete(String key);
}

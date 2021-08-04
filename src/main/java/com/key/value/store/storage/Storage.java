package com.key.value.store.storage;

public interface Storage {
    void upsert(String key, String value);
    void delete(String key);
}

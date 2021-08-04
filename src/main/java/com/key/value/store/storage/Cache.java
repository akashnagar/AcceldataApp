package com.key.value.store.storage;

public interface Cache {
    void upsert(String key, String value);
    void delete(String key);
    String get(String key);
    boolean containsKey(String key);
}

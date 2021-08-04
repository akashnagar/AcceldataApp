# AcceldataApp
 
Thread safety ensured by:
1. InMemory store uses ConcurrentHashMap
2. All file I/O methods are synchronized

The project can be directly cloned and run.
```diff
- I've tested this on Windows OS (as shown in the demo during interview)
```

Features to add:
1. Cache Eviction
2. Bucketing in FileSystem on exceeding some Threshold
3. Unit tests
4. Integration tests

Curls:

1. Get key
```
curl --location --request GET 'localhost:8080/key5'
```

2. Put key
```
curl --location --request POST 'localhost:8080/upsert/key4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "xy":"zz",
    "yz":"abc"
}'
```

3. Delete key
```
curl --location --request DELETE 'localhost:8080/key2'
```

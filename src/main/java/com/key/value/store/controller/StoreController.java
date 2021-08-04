package com.key.value.store.controller;

import com.key.value.store.dto.StoreKeyUpdateRequest;
import com.key.value.store.service.StoreService;
import com.key.value.store.util.Constants;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping("/{key}")
    public ResponseEntity get(@PathVariable("key") String  key){
        return ResponseEntity.ok(storeService.get(key));
    }

    @PostMapping("/upsert/{key}")
    public ResponseEntity upsert(@PathVariable("key") String  key, @RequestBody String jsonValue){
        storeService.upsert(key, jsonValue);
        return  ResponseEntity.ok(Constants.SUCCESS_MESSAGE);
    }

    @DeleteMapping("/{key}")
    public ResponseEntity delete(@PathVariable("key") String  key){
        storeService.delete(key);
        return  ResponseEntity.ok(Constants.SUCCESS_MESSAGE);
    }
}

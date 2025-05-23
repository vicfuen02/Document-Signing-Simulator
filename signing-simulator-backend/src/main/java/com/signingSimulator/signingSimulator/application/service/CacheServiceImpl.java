package com.signingSimulator.signingSimulator.application.service;

import com.signingSimulator.signingSimulator.application.ports.input.CacheService;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;

@Controller
public class CacheServiceImpl implements CacheService {

    private static Map<String, Map<String, Object>> CACHE = new HashMap<String, Map<String, Object>>();


    public CacheServiceImpl() {
    }

    public Map<String, Map<String, Object>> getCACHE() {
        return CACHE;
    }

    public void setCACHE(Map<String, Map<String, Object>> CACHE) {
        CacheServiceImpl.CACHE = CACHE;
    }


    public Map<String, Object> getStoredValues(String cacheKey) {

        if (!CACHE.containsKey(cacheKey)) {
            CACHE.put(cacheKey, new HashMap<String, Object>());
        }

        return CACHE.get(cacheKey);
    }

    public void setValueCache(String cacheKey, String key, Object obj) {

        if (!CACHE.containsKey(cacheKey)) {
            CACHE.put(cacheKey, new HashMap<String, Object>());
        }

        CACHE.get(cacheKey).put(key, obj);
    }

}

package com.signingSimulator.signingSimulator.application.ports.input;

import java.util.Map;

public interface CacheService {

    Map<String, Map<String, Object>> getCACHE();

    void setCACHE(Map<String, Map<String, Object>> CACHE);

    Map<String, Object> getStoredValues(String cacheKey);

    void setValueCache(String cacheKey, String key, Object obj);
}

package com.sqs.project.aktienanzeiger;

import com.sqs.project.aktienanzeiger.service.CacheService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

class CacheServiceTest {

    @Mock
    private RedisTemplate<String, String> redisTemplate;

    @Mock
    private ValueOperations<String, String> valueOperations;

    @InjectMocks
    private CacheService cacheService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(redisTemplate.opsForValue()).thenReturn(valueOperations);
    }

    @Test
    void testGetFromCache() {
        String key = "testKey";
        String expectedValue = "testValue";

        when(valueOperations.get(key)).thenReturn(expectedValue);

        String actualValue = cacheService.getFromCache(key);

        verify(valueOperations, times(1)).get(key);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testSaveToCache() {
        String key = "testKey";
        String data = "testData";
        long timeout = 10;
        TimeUnit unit = TimeUnit.MINUTES;

        doNothing().when(valueOperations).set(anyString(), anyString(), anyLong(), any(TimeUnit.class));

        cacheService.saveToCache(key, data, timeout, unit);

        verify(valueOperations, times(1)).set(key, data, timeout, unit);
    }

    @Test
    void testDeleteFromCache() {
        String key = "testKey";

        when(redisTemplate.delete(anyString())).thenReturn(null);

        cacheService.deleteFromCache(key);

        verify(redisTemplate, times(1)).delete(key);
    }
}

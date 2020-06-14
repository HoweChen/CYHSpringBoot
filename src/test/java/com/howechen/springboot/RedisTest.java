package com.howechen.springboot;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends BaseDBTest {

  private final static String HMKEY = "hash";

  @Autowired
  @Qualifier(value = "com.howechen.springboot.redisTemplate")
  private RedisTemplate<Object, Object> redisTemplate;

  @Test
  public void givenMap_putAndGet_shouldSucceed() {
    Map<String, String> map = new HashMap<>() {{
      put("key1", "val1");
      put("key2", "val2");
    }};

    final HashOperations<Object, Object, Object> hashOp = redisTemplate
        .opsForHash();

    hashOp.putAll(HMKEY, map);

    final Map<Object, Object> entries = hashOp.entries(HMKEY);

    assert entries.equals(map);

  }

//  @Test
//  public void givenKV_


}

package com.howechen.springboot;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

import java.util.HashMap;
import java.util.Map;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisTest extends BaseDBTest {

  private final static String HMKEY = "hash";

  @SuppressWarnings({"unchecked", "rawtypes"})
  private void flushDB() {
    redisTemplate.execute((RedisCallback) connection -> {
      connection.flushDb();
      return null;
    });
  }

  @Before
  public void init() {
    flushDB();
  }

  @After
  public void postTest() {
    flushDB();
  }

  @Autowired
  @Qualifier(value = "com.howechen.springboot.redisTemplate")
  private RedisTemplate<String, String> redisTemplate;

  @Test
  public void givenMap_putAndGet_shouldSucceed() {
    Map<String, String> map = new HashMap<>() {{
      put("key1", "val1");
      put("key2", "val2");
    }};

    final HashOperations<String, String, String> hashOp = redisTemplate
        .opsForHash();

    hashOp.putAll(HMKEY, map);

    final Map<String, String> entries = hashOp.entries(HMKEY);

    assertThat(entries).isEqualTo(map);

  }

  @Test
  public void givenKV_putAndGet_shouldSucceed() {
    final String key = "key3";
    final String val = "val3";

    final HashOperations<String, Object, String> hashOp = redisTemplate
        .opsForHash();

    try {
      hashOp.put(HMKEY, key, val);
    } catch (Exception ex) {
      fail("Failed");
    }

    final String result = hashOp.get(HMKEY, key);

    assertThat(result).isEqualTo(val);
  }


}

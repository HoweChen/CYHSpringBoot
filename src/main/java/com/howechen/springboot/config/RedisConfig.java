package com.howechen.springboot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@RequiredArgsConstructor(onConstructor = @__({@Autowired}))
public class RedisConfig {

  private final RedisProperties redisProperties;

  @Bean
  LettuceConnectionFactory redisConnection() {
    return new LettuceConnectionFactory(
        new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort()));
  }

  @Bean(value = "com.howechen.springboot.redisTemplate")
  public RedisTemplate<String, String> rTpl(
      @Qualifier("redisConnection") LettuceConnectionFactory lettuceConnectionFactory) {
    RedisTemplate<String, String> template = new RedisTemplate<>();
    template.setConnectionFactory(lettuceConnectionFactory);
    template.setEnableTransactionSupport(true);

    return template;
  }
}

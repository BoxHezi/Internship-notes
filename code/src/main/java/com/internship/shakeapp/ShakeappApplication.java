package com.internship.shakeapp;

import com.internship.shakeapp.entity.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
@MapperScan("com.internship.shakeapp.dao")
@EnableCaching
public class ShakeappApplication {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate<String, Company> companyRedisTemplate() {
        RedisTemplate<String, Company> companyRedisTemplate = new RedisTemplate<>();
        companyRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return companyRedisTemplate;
    }

    @Bean
    RedisTemplate<String, Draw> drawRedisTemplate() {
        RedisTemplate<String, Draw> drawRedisTemplate = new RedisTemplate<>();
        drawRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return drawRedisTemplate;
    }

    @Bean
    RedisTemplate<String, Product> productRedisTemplate() {
        RedisTemplate<String, Product> productRedisTemplate = new RedisTemplate<>();
        productRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return productRedisTemplate;
    }

    @Bean
    RedisTemplate<String, User> userRedisTemplate() {
        RedisTemplate<String, User> userRedisTemplate = new RedisTemplate<>();
        userRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return userRedisTemplate;
    }

    @Bean
    RedisTemplate<String, WinRecord> winRecordRedisTemplate() {
        RedisTemplate<String, WinRecord> winRecordRedisTemplate = new RedisTemplate<>();
        winRecordRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return winRecordRedisTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(ShakeappApplication.class, args);
    }

}

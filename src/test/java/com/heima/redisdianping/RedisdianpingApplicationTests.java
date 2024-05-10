package com.heima.redisdianping;

import com.heima.redisdianping.redis.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RedisdianpingApplicationTests {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    void testString() {
        redisTemplate.opsForValue().set("mylover","baby");
        Object mylover = redisTemplate.opsForValue().get("mylover");
        System.out.println(mylover);
    }
    @Test
    void testsaveUser(){
        redisTemplate.opsForValue().set("user:100",new User("宝宝",24));
        User o = (User) redisTemplate.opsForValue().get("user:100");
        System.out.println("user:100："+o);
    }
}

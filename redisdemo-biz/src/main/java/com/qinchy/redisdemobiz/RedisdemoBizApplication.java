package com.qinchy.redisdemobiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.qinchy")
public class RedisdemoBizApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisdemoBizApplication.class, args);
	}
}

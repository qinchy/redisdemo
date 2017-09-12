package com.qinchy.redisdemobiz.controller;

import com.qinchy.redisdemodao.config.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/caches")
public class CacheController {

    private Logger log = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    public String test(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        redisUtils.set(key, value);
        log.info("进入了方法");
        String string = redisUtils.get(key).toString();
        return string;
    }

}
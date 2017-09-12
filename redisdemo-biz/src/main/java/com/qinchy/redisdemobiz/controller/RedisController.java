package com.qinchy.redisdemobiz.controller;

import com.qinchy.redisdemoapi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(path="/set",method = RequestMethod.GET)
    public boolean set(@RequestParam(value="key") String key,@RequestParam(value="value") String value){
        return redisService.set(key, value);
    }

    @RequestMapping(path="/get",method = RequestMethod.GET)
    public String get(@RequestParam(value="key") String key){
        return redisService.get(key);
    }
}

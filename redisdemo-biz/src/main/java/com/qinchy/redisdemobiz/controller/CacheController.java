package com.qinchy.redisdemobiz.controller;

import com.qinchy.redisdemodao.config.RedisUtils;
import com.qinchy.redisdemodao.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//import java.util.ArrayList;
//import java.util.List;


@RestController
@RequestMapping("/caches")
public class CacheController {

    private Logger log = LoggerFactory.getLogger(CacheController.class);

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/setstring")
    public String setString(@RequestParam(value = "key") String key, @RequestParam(value = "value") String value) {
        log.info("进入了setString方法");
        redisUtils.set(key, value);
        String string = redisUtils.get(key).toString();
        return string;
    }

    @RequestMapping("/setobject")
    public String setObject(@RequestParam(value = "username") String username, @RequestParam(value = "age") Integer age) {
        log.info("进入了setObject方法");
        User user = new User(username, age);
//        List<User> users = new ArrayList<User>();
//        users.add(user);
        boolean setFlag = redisUtils.set(username, user);
        log.info("set方法返回值：" + setFlag);
        Object o = redisUtils.get(username);
        if (null != o) {
            return o.toString();
        }
        return null;
    }

}
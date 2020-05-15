package com.angsivip.consumer.controller;

import com.angsivip.consumer.domain.User;
import com.angsivip.consumer.provider.api.UserProviderApi;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户控制层
 * @author: 尹碧波  Created in 2020/4/4 16:57
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户测试活动")
public class UserController {

    @Autowired
    private UserProviderApi userProviderApi;


    @PostMapping("create")
    public void create(@RequestBody User user) {
        userProviderApi.create(user);
    }
}

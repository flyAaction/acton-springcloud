package com.angsivip.consumer.provider.impl;

import com.angsivip.consumer.domain.User;
import com.angsivip.consumer.mapper.UserMapper;
import com.angsivip.consumer.provider.api.UserProviderApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: 尹碧波  Created in 2020/4/4 16:54
 */
@Service
public class UserProviderImpl implements UserProviderApi {

    @Autowired
    private UserMapper userMapper;


    @Override
    public int create(User user) {
        return userMapper.insert(user);
    }
}

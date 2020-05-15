package com.angsivip.consumer.mapper;

import com.angsivip.consumer.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: 尹碧波  Created in 2020/4/4 16:47
 */
@Mapper
public interface UserMapper {

    int insert(User user);

}

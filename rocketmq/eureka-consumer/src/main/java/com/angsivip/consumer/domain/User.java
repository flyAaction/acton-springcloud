package com.angsivip.consumer.domain;


import lombok.Data;

import java.io.Serializable;

/**
 * @author: 尹碧波  Created in 2020/4/4 16:28
 */
@Data
public class User implements Serializable {

    private Integer id;

    private String name;

    private Integer sex;

}

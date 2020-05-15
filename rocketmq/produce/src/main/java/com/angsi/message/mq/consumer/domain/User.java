package com.angsi.message.mq.consumer.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 测试用户
 */
@Data
public class User implements Serializable {

    private String name;

    private int id;

}

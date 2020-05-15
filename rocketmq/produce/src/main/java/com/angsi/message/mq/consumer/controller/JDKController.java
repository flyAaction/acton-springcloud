package com.angsi.message.mq.consumer.controller;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * jdk 1.8 + 特性 控制
 *
 * @author: 尹碧波  Created in 2020/4/28 15:02
 */
public class JDKController {




    /**
     * 内部比较
     */
    public synchronized  static void arrayList() {
        List<String> name = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(name, (a, b) -> b.compareTo(a));
    }
}

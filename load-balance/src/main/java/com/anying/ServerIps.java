package com.anying;

import java.util.*;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 13:30
 */
public class ServerIps {

    //服务器当前的活跃数
    public static final Map<String, Integer> ACTIVITY_LIST = new LinkedHashMap<String,Integer>();

    static {
        ACTIVITY_LIST.put("192.168.0.1", 2);
        ACTIVITY_LIST.put("192.168.0.2", 0);
        ACTIVITY_LIST.put("192.168.0.3", 1);
        ACTIVITY_LIST.put("192.168.0.4", 3);
        ACTIVITY_LIST.put("192.168.0.5", 0);
        ACTIVITY_LIST.put("192.168.0.6", 1);
        ACTIVITY_LIST.put("192.168.0.7", 4);
        ACTIVITY_LIST.put("192.168.0.8", 2);
        ACTIVITY_LIST.put("192.168.0.9", 7);
        ACTIVITY_LIST.put("192.168.0.10", 3);
    }

    public static final Map<String, Integer> WEIGHT_LIST = new HashMap<String, Integer>();
    static {
//            WEIGHT_LIST.put("A", 5);
//            WEIGHT_LIST.put("B", 3);
//            WEIGHT_LIST.put("C", 2);
        WEIGHT_LIST.put("192.168.0.1", 9);
        WEIGHT_LIST.put("192.168.0.2", 1);
        WEIGHT_LIST.put("192.168.0.3", 8);
        WEIGHT_LIST.put("192.168.0.4", 2);
        WEIGHT_LIST.put("192.168.0.5", 5);
        WEIGHT_LIST.put("192.168.0.6", 5);
        WEIGHT_LIST.put("192.168.0.7", 4);
        WEIGHT_LIST.put("192.168.0.8", 7);
        WEIGHT_LIST.put("192.168.0.9", 2);
        WEIGHT_LIST.put("192.168.0.10", 9);
    }

    public static final List<String> LIST = Arrays.asList(
            "192.168.0.1",
            "192.168.0.2",
            "192.168.0.3",
            "192.168.0.4",
            "192.168.0.5",
            "192.168.0.6",
            "192.168.0.7",
            "192.168.0.8");

}

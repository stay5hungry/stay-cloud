package com.anying.roundrobin;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 14:28
 */
public class Sequence {
    public static Integer num = 0;
    public static Integer getAndIncrement() {
        return ++num;
    }
}

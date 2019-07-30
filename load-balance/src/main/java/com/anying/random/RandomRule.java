package com.anying.random;

import com.anying.ServerIps;

import java.util.Random;

/**
 * @Description: 简单随机
 * @author: qiuz
 * @date: 2019/7/29 13:32
 */
public class RandomRule {

    /**
     *
     * @return
     */
    public static String getServer(){
        Random random = new Random();
        int i = random.nextInt(ServerIps.LIST.size());
        return ServerIps.LIST.get(i);
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(getServer());
        }
    }
}

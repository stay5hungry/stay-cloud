package com.anying.random;

import com.anying.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 13:54
 */
public class WeightRandom {

    public static String getServer(){
        List<String> ips = new ArrayList<String>();

        for(String ip:ServerIps.WEIGHT_LIST.keySet()){
            Integer weight = ServerIps.WEIGHT_LIST.get(ip);
            //按权重进行复制
            for(int i= 0; i<weight;i++){
                ips.add(ip);
            }
        }

        Random random = new Random();
        int i = random.nextInt(ips.size());
        return ips.get(i);
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(getServer());
        }
    }
}

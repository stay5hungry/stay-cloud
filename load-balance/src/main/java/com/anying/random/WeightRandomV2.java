package com.anying.random;

import com.anying.ServerIps;

import java.util.Random;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 14:05
 */
public class WeightRandomV2 {

    public static String getServer(){
        //1、计算权重和
        int totalWeight = 0;

        boolean sameWeight = true; //如果所有权重相等，那么随机一个ip就可以了
        Object[] weights = ServerIps.WEIGHT_LIST.values().toArray();
        for(int i = 0;i<weights.length;i++){
            Integer weight = (Integer) weights[i];
            totalWeight += weight;
            if(sameWeight && i>0 && !weight.toString().equals(weights[i-1].toString())){
                sameWeight = false;
            }
        }

        Random random = new Random();
        int pos = random.nextInt(totalWeight);

        if(!sameWeight){
            for(String ip:ServerIps.WEIGHT_LIST.keySet()){
                Integer value = ServerIps.WEIGHT_LIST.get(ip);
                if(pos<value){
                    return ip;
                }
                pos = pos - value;
            }
        }
        return (String) ServerIps.WEIGHT_LIST.keySet().toArray()[new java.util.Random().nextInt(ServerIps.WEIGHT_LIST.size())];
    }

    public static void main(String[] args) {
        for (int i=0; i<100; i++) {
            System.out.println(getServer());
        }
    }
}

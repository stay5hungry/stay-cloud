package com.anying.roundrobin;

import com.anying.ServerIps;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 14:41
 */
public class WeightRoundRobinV2 {

    private static Map<String, Weight> weightMap = new HashMap<String, Weight>();

    public static String getServer() {
        //1、计算总权重
        int totalWeight = ServerIps.WEIGHT_LIST.values().stream().reduce(0,(w1,w2)->w1+w2);
        //2、初始化weightMap 初始化时将currentWeight赋值为weight
        if(weightMap.isEmpty()){
            ServerIps.WEIGHT_LIST.forEach((key,value)->{
                weightMap.put(key,new Weight(key,value,value));
            });
        }

        //3、找出currentWeight最大值
        Weight maxWeight = null;
        for(Weight weight:weightMap.values()){
            if(maxWeight == null || weight.getCurrentWeight()>maxWeight.getCurrentWeight()){
                maxWeight = weight;
            }
        }

        //将max减去总权重
        maxWeight.setCurrentWeight(maxWeight.getCurrentWeight()-totalWeight);

        //所有的ip的currentWeight统一加上原始权重
        for (Weight weight:weightMap.values()){
            weight.setCurrentWeight(weight.getWeight()+weight.getCurrentWeight());
        }

        //返回max对应的ip
        return maxWeight.getIp();

    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}

package com.anying.roundrobin;

import com.anying.ServerIps;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 14:21
 */
public class RoundRobin {

    //当前位置
    private static Integer pos = 0;

    public static String getServer() {
        String ip = null;
        synchronized (pos){
            if (pos >= ServerIps.LIST.size()) {
                pos = 0;
            }
            ip = ServerIps.LIST.get(pos);
            pos++;
        }
        return ip;
    }

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.println(getServer());
        }
    }

}

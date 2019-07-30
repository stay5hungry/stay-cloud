package com.anying.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 11:18
 */
public class StayRule extends AbstractLoadBalancerRule {

    Random rand;

    private int lastIndex = -1; //最后一次
    private int nowIndex = -1; //当前下标
    private int skipIndex = -1; //跳过的下标

    public StayRule() {
        rand = new Random();
    }

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

                int index = this.rand.nextInt(serverCount);
                System.out.println("当前下标为："+index);
                if(skipIndex>=0 && skipIndex == index){
                    System.out.println("跳过的下标为："+skipIndex);
                    index = this.rand.nextInt(serverCount);
                    System.out.println("跳过后的下表为："+index);
                }
                skipIndex=-1;
                nowIndex = index;

                if(nowIndex == lastIndex){
                    System.out.println("下一次需要跳过的下标"+nowIndex);
                    skipIndex = nowIndex;
                }
                lastIndex = nowIndex;

                server = (Server)upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }
}

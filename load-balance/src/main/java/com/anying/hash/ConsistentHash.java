package com.anying.hash;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description:
 * @author: qiuz
 * @date: 2019/7/29 15:43
 */
public class ConsistentHash {

    private static SortedMap<Integer, String> virtualNodes = new TreeMap<>();

    private static final int VIRTUAL_NODES = 160;//虚拟节点的个数

}

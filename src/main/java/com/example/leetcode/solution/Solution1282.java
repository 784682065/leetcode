package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:27 2020/5/1
 * @param:
 */
public class Solution1282 {


    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();

        //粗分组
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            //1.首先看map中是否包含该组数组
            if (!hashMap.containsKey(size)) {
                hashMap.put(size, new ArrayList<>());
            }


            //2.拿出map中该组数量作为key的 list,并增加元素
            ArrayList<Integer> list = hashMap.get(size);
            list.add(i);

            //3.如果list 长度等于该组元素长度,则提取放入结果数组
            if (list.size() == size) {
                res.add(list);
                hashMap.put(size, new ArrayList<>());
            } else {
                hashMap.put(size, list);
            }

        }

        return res;
    }
}

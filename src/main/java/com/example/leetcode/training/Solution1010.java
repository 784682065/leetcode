package com.example.leetcode.training;

import java.util.Arrays;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  21:14 2020/5/14
 * @param:
 */
public class Solution1010 {

    /**
     * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
     * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
     * 形式上，我们希望索引的数字 i 和 j 满足  i < j
     * 且有 (time[i] + time[j]) % 60 == 0。
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {

        /**
         * 整数对60取模，可能有60种余数。故初始化一个长度为60的数组，统计各余数出现的次数。
         * 遍历time数组，每个值对60取模，并统计每个余数值（0-59）出现的个数。因为余数部分需要找到合适的cp组合起来能被60整除。
         * 余数为0的情况，只能同余数为0的情况组合（如60s、120s等等）。0的情况出现k次，则只能在k中任选两次进行两两组合。本题解单独写了个求组合数的方法，也可以用k * (k - 1) / 2表示。
         * 余数为30的情况同上。
         * 其余1与59组合，2与58组合，故使用双指针分别从1和59两头向中间遍历。
         * 1的情况出现m次，59的情况出现n次，则总共有m*n种组合。
         *
         */

        int[] arr = new int[60];
        Arrays.stream(time).forEach(value -> arr[value % 60]++);

        int count = 0;
        for (int i = 0; i <= 30; i++) {
            if (i == 0 || i ==30 ) {
                count += arr[i] * (arr[i] - 1) / 2;
                continue;
            }

            count += arr[i] * arr[arr.length - i];
        }

//        int count = 0;
//        for (int i = 0; i < time.length; i++) {
//            for (int j = i + 1; j < time.length; j++) {
//                if ((time[i] + time[j]) % 60 == 0) {
//                    count++;
//                }
//            }
//        }

        return count;
    }
}

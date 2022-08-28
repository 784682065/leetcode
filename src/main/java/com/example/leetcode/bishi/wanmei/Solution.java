package com.example.leetcode.bishi.wanmei;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int[][] mergeCard(int[][] cards) {

        // 在这⾥写代码
        Arrays.sort(cards, Comparator.comparingInt(c -> c[0]));
        int[][] ans = new int[cards.length][cards[0].length];
        int index = -1;
        for(int[] c : cards){
            if(index == -1 || c[0] > ans[index][1]){
                index += 1;
                ans[index] = c;
            }else{
                // 区间重合状态
                ans[index][1] = Math.max( ans[index][1],c[1]);
            }
        }
        int len = index+1;
        int[][] res = new int[len][2];

        for(int i =0 ; i < len; i++){
            res[i][0] = ans[i][0];
            res[i][1] = ans[i][1];
        }
        return res;
    }
}

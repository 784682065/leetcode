package com.example.leetcode.training;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:10 2020/5/14
 * @param:
 */
public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0) {
            // 总和不是3的倍数，直接返回false
            return false;
        }
        int s = 0;
        int flag = 0;
        for (int i : A) {
            s += i;
            if (s == sum / 3) {
                flag++;
                s = 0;
            }
        }
        // flag不一定等于3，例如[1,-1,1,-1,1,-1,1,-1]
        return flag >= 3;
    }
}

package com.example.leetcode.bishi.meidi;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public ArrayList<Integer> findPrimeNumber (int m, int n) {
        // write code here
        // 素数只能被1 或者自己整除
        ArrayList<Integer> res = new ArrayList<>();

        int k,j;
        for (int i = m; i <= n; i++) {
            k = (int) Math.sqrt(i);
            for ( j = 2; j <= k; j++) {
                // 如果能除尽,则不是素数
                if (i%j ==0)
                    break;
            }
            if (j > k){
                res.add(i);
            }
        }
        return res;
    }
}

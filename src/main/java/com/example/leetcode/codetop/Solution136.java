package com.example.leetcode.codetop;

public class Solution136 {

    // 任何数和 0 做异或运算，结果仍然是原来的数，即 a ^ 0==a。
    //任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
    //异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
    public int singleNumber(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }
}

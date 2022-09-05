package com.example.leetcode.codetop;

import java.util.HashSet;
import java.util.Set;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i <nums2.length; i++) {
            if (set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int[] resArr = new int[res.size()];
        int i =0;
        for (Integer r : res) {
            resArr[i++] = r;
        }
        return resArr;
    }
}

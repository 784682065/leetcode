package com.example.leetcode.solution;

import java.util.HashMap;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  8:21 2020/1/8
 * @param:
 */
public class Solution13 {

    public int romanToInt(String s) {
        HashMap<String,Integer> map= new HashMap<>();
//        I， V， X， L，C，D 和 M。
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);

        int res = 0;
        for (int i = 0; i < s.length(); ) {
            if (i + 1< s.length() && map.containsKey(s.substring(i, i+2))){
                res = res + map.get(s.substring(i,i+2));
                i +=2;
            }else {
                res = res + map.get(s.substring(i,i+1));
                i++;

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int res = solution13.romanToInt("MCMXCIV");
        System.out.println(res);
    }

}

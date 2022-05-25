package com.example.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: hzp
 * @date: 2022/3/15
 * @description:
 */
public class Solution3 {


    public int lengthOfLongestSubstring(String s) {

        if (s.length() <=1){
            return s.length();
        }

        int start = 0;
        int end = 1;

        //拿end 位置跟前面的start 开始的位置比
        char[] chars = s.toCharArray();
        int max = 1;

        while(end < s.length()){
            for (int pos = start; pos < end; pos++) {
                if (chars[pos] ==chars[end]) {

                    max = Math.max(max,end- start);
                    start = pos+1;
                    end = end +1;
                    break;
                }
                if (pos +1 == end){
                    end= end +1;
                    break;
                }
            }


        }
        return Math.max(max,end- start);
    }

    /**
     * 使用hashSet记录的要点,就是要移动的时候记得remove左边界的值 ,
     * 不用map主要是因为 这里只可能会记录一次某个值,出现重复的时候
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int a =1;
        System.out.println(a++);
        System.out.println(++a);

    }
}

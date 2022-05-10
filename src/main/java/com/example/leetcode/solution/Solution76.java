package com.example.leetcode.solution;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: hzp
 * @date: 2022/5/10
 * @description:
 */
public class Solution76 {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {

        int tLen = t.length();
        // 统计t 字符串
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;

        int sLen = s.length();

        while (r < sLen) {
            ++r;
            // cnt 和 ori 都是为了check()方法
            if (r < sLen && ori.containsKey(s.charAt(r))) {
//                cnt 是 s 中有t 中字符串每个字符的个数
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }

            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }

                if (ori.containsKey(s.charAt(l))) {
                    // 动态hash表,由于左指针移动减少 cnt的字符的个数
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }

                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }


    public boolean check() {
        Iterator iter = ori.entrySet().iterator();

        // 只要s 中对t中每个字符的个数都大于等于ori中每个字符的个数,那就是s 包含t
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {

        Solution76 solution76 = new Solution76();

        String s = "ab";
        String t = "b";

        String s1 = solution76.minWindow(s, t);
        System.out.println(s1);


    }
}

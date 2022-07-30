package com.example.leetcode.codetop;

import java.util.*;

public class Solution76 {


    public String minWindow(String s, String t) {

        if (s.length() < t.length())
            return "";

        int windowSize = t.length() -1;
        Map<Character,Integer> windowMap = new HashMap<>();

        Map<Character,Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char charAt = t.charAt(i);
            Integer orDefault = tMap.getOrDefault(charAt, 0);
            tMap.put(charAt,++orDefault);
        }

        StringBuilder minStr = new StringBuilder();
        boolean sign = true;
        while (windowSize < s.length()){
            for (int end = windowSize; end < s.length(); ) {
                int start  = end- windowSize;
                for (int j = start; j <= end; j++) {
                    char charAt = s.charAt(j);
                    Integer orDefault = windowMap.getOrDefault(charAt, 0);
                    windowMap.put(charAt,++orDefault);

                }
                // 判断是否相等, 不相等则清除, 相等则放入答案,返回
                for (Map.Entry<Character, Integer> characterIntegerEntry : tMap.entrySet()) {
                    Character key = characterIntegerEntry.getKey();
                    Integer value = characterIntegerEntry.getValue();
                    if (windowMap.getOrDefault(key,0) < value){
                        sign = false;
                        break;
                    }
                }

                if (!sign){
                    // 如果没有对上,则重置,为下一轮准备
                    windowMap.clear();
                    sign = true;
                    // 需要跳跃 end,从第二个开始找起来,找到第一个对上里面的值的
                    for (int i = start+1; i <= end; i++) {
                        char charAt = s.charAt(i);
                        if (tMap.containsKey(charAt)){
                            end = windowSize + i ;
                            break;
                        }
                        if ( i == end){
                            ++end;
                        }
                    }
                }else {
                    for (int j = start; j <= end; j++) {
                        char charAt = s.charAt(j);
                        minStr.append(charAt);
                    }
                    return minStr.toString();
                }
            }
            //变大窗口在寻找一次
            ++windowSize;
        }
        return "";
    }


    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindowOffical(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                // 比最短的长度短, 目前找到的比最短长度短.
                if (r - l + 1 < len) {
                    // 记录答案
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                // 开始移动左边 L的边界 ,一个小技巧,cnt不用记录 t字符串没有的值
                // 当无法满足check() 要求的时候, r在开始移动右边边界
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
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
        String s = "abbbbbcdd", t = "abcdd";
        Solution76 solution76 = new Solution76();
        System.out.println(solution76.minWindow(s, t));

    }

}

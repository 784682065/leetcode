package com.example.leetcode.ttt;

import javafx.beans.binding.ObjectExpression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main1 {
    /**
     * 1. 初始化两个HashMap,h1 与 h2 , 一个计算每个字母出现次数, 另一个K-V存放,出现次数和 当前的字母数组
     * 2. 遍历 输入字符串, 从h1得到当前该字母出现次数,次数加一, 分别存入 h1 ,与 h2. 如果h2 里当前出现次数没新建list,则新建后加入
     */
    void count(String str) {
        int max = 0;
        HashMap<Integer,List<Character>> hashMap = new HashMap<>();
        HashMap<Character,Integer> hm = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            int times = hm.getOrDefault(charAt, 0) + 1;
            hm.put(charAt, times);
            if (times > max){
                max = times;
            }

            List<Character> orDefault = hashMap.getOrDefault(times, new ArrayList<>());
            orDefault.add(charAt);
            hashMap.put(times,orDefault);
        }

        List<Character> characters = hashMap.get(max);
        System.out.println(characters);
    }
}

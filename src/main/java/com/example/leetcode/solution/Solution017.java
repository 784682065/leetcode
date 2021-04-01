package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:26 2020/1/9
 * @param:
 */
public class Solution017 {
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        if (digits.length() != 0)
            backtrack(result, "", digits);
        return result;
    }

    public static void backtrack(List<String> result, String condition, String next_digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        if (next_digits.length() == 0) {
            result.add(condition);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = map.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = letters.substring(i, i + 1);
                backtrack(result, condition + letter, next_digits.substring(1));
            }
        }
    }

    // [ad, ae, af, bd, be, bf, cd, ce, cf]
    public static void main(String[] args) {
        String str = "23";
        System.out.println(letterCombinations(str));
    }
}

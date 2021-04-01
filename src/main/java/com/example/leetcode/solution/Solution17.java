package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: huzp
 * @Description:  电话号码的字母组合
 * @Date: Created in  9:24 2020/1/9
 * @param:
 */
public class Solution17 {


    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res = new ArrayList();


    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) return new ArrayList<>();
        itrator(digits, "", 0);
        return res;
    }

    public void itrator(String str,String condition,int pos){


        if (pos == str.length()){
            res.add(condition);
            return;
        }

        char charAt = str.charAt(pos);
        int p = charAt - '0';
        String s = letter_map[p];
        for (int i = 0; i < s.length(); i++) {
            itrator(str,condition+s.charAt(i),pos+1);
        }
    }

    public static void main(String[] args) {

//        Solution17 solution17 = new Solution17();
//        List<String> strings = solution17.letterCombinations("23");
//        System.out.println(strings);
        String d ="123456";
        d.substring(0,1);
        System.out.println(d);

    }




}

package com.example.leetcode.solution;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:23 2020/1/3
 * @param:
 */
public class Solution8 {


    public static int myAtoi(String str) {

        int maxValue = Integer.MAX_VALUE;
        int minValue = Integer.MIN_VALUE;

        String s = str.trim();
        if (s.length() == 0) return 0;

        int sign , start ;
        double res = 0;

        if (!Character.isDigit(s.charAt(0)) && s.charAt(0) != '-' && s.charAt(0) != '+') return 0;

        char[] chars = s.toCharArray();

        if ( chars[0] == '-') {
            sign =-1; start = 1;
        }else if (chars[0] == '+'){
            sign =1; start = 1;
        }else {
            sign =1; start = 0;
        }

        for (int i = start ; i< chars.length ; i++){

            if (!Character.isDigit(chars[i])){
                break;
            }else {
               res = res*10 + chars[i] -'0';
            }
        }

        if (sign == 1 && res >maxValue) return maxValue;
        if (sign == -1 && res-1 > maxValue) return minValue;

        return (int) (sign*res);
    }

    public static void main(String[] args) {
        int i = myAtoi("9223372036854775808");
        System.out.println(i);
    }

}

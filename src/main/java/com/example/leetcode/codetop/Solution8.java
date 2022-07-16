package com.example.leetcode.codetop;

public class Solution8 {

    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()){
            return 0;
        }
        int sign = 1;
        int index = 0;
        int res = 0;
        char charAt = s.charAt(index);
        if (charAt == '-') {
            sign = -1;
            index++;
        }else if (charAt == '+'){
            index++;
        }

        for (int i = index; i < s.length(); i++) {
            charAt = s.charAt(i);
            if (!(Character.isDigit(charAt))) {
                break;
            }
            // 提前判断尾数
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (charAt - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (charAt - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + sign* (charAt - '0');
        }

        return res;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        int i = solution8.myAtoi("-419111111111131111  words");
        System.out.println(i);


    }
}

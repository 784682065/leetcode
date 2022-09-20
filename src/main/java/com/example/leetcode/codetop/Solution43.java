package com.example.leetcode.codetop;

public class Solution43 {

    public String multiply(String num1, String num2) {

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 总是把短的放到num1
        if (num1.length() > num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }

        String ans = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            StringBuffer sum = new StringBuffer();
            for (int j = num1.length() - 1 - i; j > 0; j--) {
                sum.append(0);
            }
            Integer i1 = num1.charAt(i) - '0';
            int remainder = 0;
            int acount;
            for (int j = num2.length() - 1; j >= 0; j--) {
                Integer i2 = num2.charAt(j) - '0';
                acount = i1 * i2 + remainder;
                //保留尾数
                sum.append(acount % 10);
                remainder = acount / 10;
            }
            if (remainder != 0) {
                sum.append(remainder);
            }
            ans = addStrings(ans, sum.reverse().toString());
        }


        return ans;
    }

    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1, add = 0;
        StringBuffer ans = new StringBuffer();
        while (i >= 0 || j >= 0 || add != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            i--;
            j--;
        }
        ans.reverse();
        return ans.toString();
    }


}

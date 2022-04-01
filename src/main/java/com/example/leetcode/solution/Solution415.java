package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/4/1
 * @description:
 */
public class Solution415 {
    public String addStrings(String num1, String num2) {

        char[] a, b;
        int n1l = num1.length();
        int n2l = num2.length();
        if (n1l >= n2l) {
            a = num1.toCharArray();
            b = num2.toCharArray();
        } else {
            a = num2.toCharArray();
            b = num1.toCharArray();
        }

        int dif = a.length - b.length;
        // sign 可以用int add代替,看起来就比较优雅
        boolean sign = false;
        StringBuilder res = new StringBuilder();
        int val;
        for (int i = a.length -1; i >= 0; i--) {
            char ca = a[i];

            if (i - dif >=0) {
                char cb = b[i - dif];
                val = ca + cb - 96;
                if (sign) {
                    val++;
                }
                res.append(val % 10);
                sign = val / 10 >= 1;
            } else {
                val = ca - 48;
                if (sign) {
                    val++;
                }
                res.append(val % 10);
                sign = val / 10 >= 1;
            }
        }

        if (sign)
            res.append(1);

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        String s = solution415.addStrings("11", "123");
        System.out.println(s);
    }

    public String OfficalAddStrings(String num1, String num2) {
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
        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }

}

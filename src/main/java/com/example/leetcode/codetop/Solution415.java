package com.example.leetcode.codetop;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution415 {


    public String addStrings(String num1, String num2) {

        String temp;
        // 保证num2 的位数少于或者等于num1, 然后num2 加上num1;
        if (num1.length() < num2.length()) {
            temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int len2 = num2.length();

        Deque<Integer> deque = new ArrayDeque<>();
        int nextJ = 0;
        int curJ = 0;
        int cur = 0;
        int value;
        int c1, c2;
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        for (int i = 0; i < len2; i++) {
            c1 = num1.charAt(index1 - i) - '0';
            c2 = num2.charAt(index2 - i) - '0';
            value = c1 + c2 + curJ;
            cur = value % 10 ;
            nextJ = value / 10;
            deque.addFirst(cur);
            curJ = nextJ;
        }

        if (index1 - len2 >= 0) {
            for (int i = index1 - len2; i >=0; i--) {
                c1 = num1.charAt(i) - '0';
                value = curJ + c1;
                cur = value % 10;
                nextJ = value / 10;
                deque.addFirst(cur);
                curJ = nextJ;
            }
        }

        if (curJ > 0){
            deque.addFirst(curJ);
        }

        StringBuilder res = new StringBuilder();
        for (Integer integer : deque) {
            res.append(integer);
        }

        return res.toString();
    }

    public String addStrings_offcial(String num1, String num2) {
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

    public static void main(String[] args) {
        Solution415 solution415 = new Solution415();
        String num1 = "584", num2 = "18";
        String s = solution415.addStrings(num1, num2);
        System.out.println(s);
    }
}

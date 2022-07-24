package com.example.leetcode.codetop;

import java.util.Stack;

public class Solution151 {
    public String reverseWords(String s) {

        String[] split = s.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].isEmpty())
                continue;
            stringBuilder.append(split[i]).append(" ");
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());

        return stringBuilder.toString();
    }


    public String reverseWordsO(String s) {
        Stack<StringBuilder> strings = new Stack<>();

        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s.length()) {
            char charAt = s.charAt(i);
            if (charAt != ' ') {
                stringBuilder.append(charAt);
            } else if (stringBuilder.length() !=0 && charAt == ' '){
                strings.push(new StringBuilder(stringBuilder));
                // 重新开始
                stringBuilder.setLength(0);
            }
            i++;
        }
        if (stringBuilder.length() !=0 )
            strings.push(stringBuilder);

        StringBuilder res = new StringBuilder();
        int size = strings.size();
        for (int j = 0; j < size; j++) {
            res.append(strings.pop());
            if (j != size -1)
                res.append(" ");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        String s = solution151.reverseWordsO("  hello world");
        System.out.println(
                s
        );

    }
}

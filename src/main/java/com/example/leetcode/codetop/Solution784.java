package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution784 {
    public List<String> letterCasePermutation(String s) {

        List<String> res = new ArrayList<>();


        StringBuilder path = new StringBuilder();
        this.dfs(s, -1, res, path);


        return res;
    }

    private void dfs(String s, int begin, List<String> res, StringBuilder path) {

        if (path.length() == s.length()) {
            res.add(path.toString());
            return;
        }

        begin += 1;
        char c = s.charAt(begin);
        // 如果是小写
        if (c >= 97) {
            // 变成大写
            StringBuilder newPath = new StringBuilder(path);
            newPath.append((char) (c - 32));
            // 大写
            dfs(s, begin, res, newPath);
            // 小写
            dfs(s, begin, res, path.append(c));
        } else if (c >= 65 && c <= 90) {
            StringBuilder newPath = new StringBuilder(path);
            newPath.append((char) (c + 32));
            dfs(s, begin, res, newPath);
            // 小写
            dfs(s, begin, res, path.append(c));
        } else {
            dfs(s, begin, res, path.append(c));
        }
    }

    private void dfs(char[] charArray, int index, List<String> res) {
        if (index == charArray.length) {
            res.add(new String(charArray));
            return;
        }

        dfs(charArray, index + 1, res);
        if (Character.isLetter(charArray[index])) {
            charArray[index] ^= 1 << 5;
            dfs(charArray, index + 1, res);
        }
    }



    public static void main(String[] args) {
        Solution784 solution784 = new Solution784();
        String s = "k5qo0LdW";
        List<String> strings = solution784.letterCasePermutation(s);
        System.out.println(strings);
    }
}

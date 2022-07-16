package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution22 {


    Set<String> res = new HashSet<>();

    public List<String> generateParenthesis(int n) {

        List<String> path = new ArrayList<>();
        res = new HashSet<>();
        dfs(path, 0, 0, 0, n);
        ArrayList<String> strings = new ArrayList<>(res);

        return strings;
    }

    private void dfs(List<String> path, int lb, int rn, int begin, int n) {

        if (path.size() == 2 * n) {
            StringBuilder stringBuilder = new StringBuilder();
            path.forEach(stringBuilder::append);
            res.add(stringBuilder.toString());
        }

        // 错误写法不需要begin
        for (int i = begin; i < 2* n; i++) {
            if (lb < n) {

                path.add("(");
                dfs(path, lb +1, rn, begin + 1, n);
                path.remove(path.size()-1);
            }
            if (rn  < lb) {
                path.add(")");
                dfs(path, lb, rn+1, begin + 1, n);
                path.remove(path.size()-1);
            }
        }


    }

    public List<String> generateParenthesis1(int n) {
        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        // Solution44 全排列需要for i 循环的原因是 数组中每个数都可以作为开头
        // 这里不需要的原因是 就两种可能性,如果没有 () 的限制的话也可以用数组, 计算 n*2 的 ( 与 )的全排列
        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        solution22.generateParenthesis(3);

    }
}

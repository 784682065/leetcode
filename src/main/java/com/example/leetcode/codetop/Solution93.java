package com.example.leetcode.codetop;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {

    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        StringBuilder path = new StringBuilder();
        dfs(s, path, 0);

        return res;
    }

    public void dfs(String s, StringBuilder path, int begin) {

        if (path.length() == s.length() + 3) {
            if (inValid(path.toString()) && path.charAt(path.length() - 1) != '.')
                res.add(new String(path));
        }

        if (begin < s.length()) {
            int charAt = s.charAt(begin) - '0';
            // 验证合理性
            if (inValid(path.toString())) {
                path.append(charAt);
                // 如果验证合理的话
                // 1. 不加. 往下传
                dfs(s, new StringBuilder(path), begin + 1);
                // 2. 加点往下传
                if (begin != s.length() - 1) {
                    path.append(".");
                    dfs(s, new StringBuilder(path), begin + 1);
                }
            }
        }
    }

    private boolean inValid(String path) {
        if (path.isEmpty())
            return true;

        String[] split = path.split("\\.");
        if (split.length == 0) {
            return Integer.parseInt(path) <= 255;
        }
        if (split.length > 4)
            return false;

        // 看每部分大小 , 且不能有前导 0
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (s.length() > 1 && s.startsWith("0"))
                return false;
            if (Integer.parseInt(s) > 255) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        List<String> strings = solution93.restoreIpAddresses("0000");
        System.out.println(
                strings
        );
    }

}

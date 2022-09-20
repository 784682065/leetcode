package com.example.leetcode.codetop;

import java.util.*;

public class Solution139 {


//    boolean res;
//
//    public boolean wordBreak(String s, List<String> wordDict) {
//
//        res = false;
//        dfs(s, wordDict);
//        return res;
//    }

    public boolean wordBreakDP(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);
        for (int i = 1; i <= n; i++) {
            for (int k = 0; k < wordDict.size() && !dp[i]; k++) {
                int j = i - wordDict.get(k).length();
                if (j >= 0) {
                    dp[i] = dp[j] && set.contains(s.substring(j, i));
                }
            }
        }
        return dp[n];
    }

    //    private void dfs(String s, List<String> wordDict) {
//        if (s.isEmpty()) {
//            res = true;
//            return;
//        }
//        if (!res) {
//            for (String s1 : wordDict) {
//                int length = s1.length();
//                if (s.length() >= length && s1.equals(s.substring(0, length))) {
//
//                    dfs(s.substring(length), wordDict);
//                }
//            }
//        }
//    }
    // 快速判断是否存在某个单词
// 记录 [i...n-1] 是否可以拆分成单词
// 0 : 表示还未处理该子问题；1 : 表示可以；-1 : 表示不可以
    private int[] emeo;
    private Set<String> wordSet = new HashSet<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        wordSet.addAll(wordDict);
        emeo = new int[s.length()];
        return backtrack(s, 0);
    }

    private boolean backtrack(String s, int start) {
        if (start == s.length()) return true;
        // 如果子问题已经处理过了，直接返回结果
        if (emeo[start] != 0)
            return emeo[start] == 1;

        for (int i = start; i < s.length(); i++) {
            String subStr = s.substring(start, i + 1);

            if (!wordSet.contains(subStr))
                continue;

            boolean subRes = backtrack(s, i + 1);
            if (subRes) {
                // 说明 [start...n-1] 是可以拆分成单词的
                emeo[start] = 1;
                return true;
            }
        }
        // 已经完整遍历 [start...n-1] 都无法拆分
        emeo[start] = -1;
        return false;
    }


    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        Solution139 solution139 = new Solution139();
        System.out.println(solution139.wordBreakDP(s, wordDict));

    }
}

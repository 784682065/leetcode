package com.example.leetcode.huawei;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: huzepeng
 * @date: 2022/9/26
 * @desc:
 */
public class Solution1 {
    /**
     * 题目描述
     * 编写程序，产生由1，2，3这3个数字符号所构成、长度为n的字符串，并且在字符串中对于任何一个子串而言，都不会有相邻的、完全相同的子串；
     * 解答要求
     * 时间限制：1000ms, 内存限制：100MB
     * 输入
     * 字符串长度n(1=<n<=10)；
     * 输出
     * 无相邻重复子串的所有字符串，每个字符串换行输出。(由小到大输出)
     * 样例
     * 输入样例
     * 5
     * 输出样例
     * 12131
     * 12132
     * 12312
     * 12313
     * 12321
     * 13121
     * 13123
     * 13212
     * 13213
     * 13231
     * 21231
     * 21232
     * 21312
     * 21321
     * 21323
     * 23121
     * 23123
     * 23132
     * 23212
     * 23213
     * 31213
     * 31231
     * 31232
     * 31321
     * 31323
     * 32123
     * 32131
     * 32132
     * 32312
     * 32313
     */
    List<String> res;
    int[] nums = {1, 2, 3};

    public List<String> getSubString(int n) {
        res = new ArrayList<>();
        dfs(n, 0, nums, new StringBuffer(),-1);
        return new ArrayList<>(res);
    }
    private void dfs(int n, int begin, int[] nums, StringBuffer cur,int pre) {

        if (cur.length() == n) {
            String r = new String(cur);
            res.add(r);
            return;
        }

        for (int i = begin; i < 3; i++) {
            if (nums[i]== pre)
                continue;

            cur.append(nums[i]);
            dfs(n, (begin + 1) % 3, nums, cur,nums[i]);
            // 回溯
            cur.deleteCharAt(cur.length() - 1);
        }
    }

    public static boolean JudgeRepeat(String tempStr) {
        return !tempStr.matches("(\\d+|\\b)(\\d+)\\2(\\d+|\\b)");
    }


    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<String> subString = solution1.getSubString(5);
        List<String> ans = new ArrayList<>();
        for (String s : subString) {
            if (JudgeRepeat(s)) {
                ans.add(s);
            }
        }
        ans.forEach(System.out::println);
    }


}

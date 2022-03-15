package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: hzp
 * @date: 2021/11/17
 * @description:
 */
public class Solution51 {

    public List<List<String>> solveNQueens(int n) {


        List<List<String>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> record = new ArrayList<>();
            List<String> ans = new ArrayList<>();
            record.add(i);
            ans.add(setQueens(i, n));
            func(res, record, ans ,n);
        }


        return res;
    }

    // 回溯法解决问题
    private void func(List<List<String>> res, List<Integer> record, List<String> ans, int len) {

        // 减枝
        if (record.size() == len) {
            res.add(ans);
            return;
        }

        //放一个位置 不能再lastIndex +1 和 lastIndex - 1 ,也不能被record 包含
        for (int i = 0; i < len; i++) {
            // 判定条件需要修改
            boolean sign = true;
            for (int j = 0; j < record.size(); j++) {
                int reVal = record.get(j);
                int minusVal = record.size() - j ;
                if (!((i != reVal - minusVal) && (i != reVal + minusVal) && (!record.contains(i)))) {
                    sign = false;
                    break;
                }
            }

            if (sign){
                List<Integer> r = new ArrayList<>(record);
                List<String> a = new ArrayList<>(ans);
                r.add(i);
                a.add(setQueens(i, len));
                func(res, r, a, len);
            }
        }
    }


    public String setQueens(int pos, int total) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < total; i++) {
            if (i == pos) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> lists = solution51.solveNQueens(4);
        System.out.println(lists);

    }
    //[["Q....","..Q..","....Q",".Q...","...Q."],["Q....","...Q.",".Q...","....Q","..Q.."],[".Q...","...Q.","Q....","..Q..","....Q"],[".Q...","....Q","..Q..","Q....","...Q."],["..Q..","Q....","...Q.",".Q...","....Q"],["..Q..","....Q",".Q...","...Q.","Q...."],["...Q.","Q....","..Q..","....Q",".Q..."],["...Q.",".Q...","....Q","..Q..","Q...."],["....Q",".Q...","...Q.","Q....","..Q.."],["....Q","..Q..","Q....","...Q.",".Q..."]]
}

package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:02 2020/1/12
 * @param:
 */
public class Solution22 {
    public List<String> generateParenthesis(int n) {

        ArrayList<String> res = new ArrayList();

        if(n == 0){
            return res;
        }

        dfs("",n,n,res);

        return res;
    }

    /**
     *
     * @param curstr 字符串
     * @param left 左边串
     * @param right 右边串
     * @param res 结果集
     */
    void dfs(String curstr, int left, int right, ArrayList<String> res){

        if(left == 0 && right == 0){
            res.add(curstr);
        }

        //如果左括号剩余数量大于右括号就剪掉
        if(left > right){
            return;
        }
        if(left > 0){
            dfs(curstr+"(",left -1,right,res);
        }
        if(right > 0){
            dfs(curstr+")",left,right - 1,res);
        }
    }


    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        while (!queue.isEmpty()) {

            Node curNode = queue.poll();
            if (curNode.left == 0 && curNode.right == 0) {
                res.add(curNode.res);
            }
            if (curNode.left > 0) {
                queue.offer(new Node(curNode.res + "(", curNode.left - 1, curNode.right));
            }
            if (curNode.right > 0 && curNode.left < curNode.right) { // 剪枝
                queue.offer(new Node(curNode.res + ")", curNode.left, curNode.right - 1));
            }
        }
        return res;
    }



    public List<String> generateParenthesis3(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        // 这里 dp 数组我们把它变成列表的样子，方便调用而已
        List<List<String>> dp = new ArrayList<>(n);

        List<String> dp0 = new ArrayList<>();
        dp0.add("");
        dp.add(dp0);

        for (int i = 1; i <= n; i++) {
            List<String> cur = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String> str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        // 枚举右括号的位置
                        cur.add("(" + s1 + ")" + s2);
                    }
                }
            }
            dp.add(cur);
        }
        return dp.get(n);
    }















    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        List<String> strings = solution22.generateParenthesis3(2);

        System.out.println(strings);
    }

}

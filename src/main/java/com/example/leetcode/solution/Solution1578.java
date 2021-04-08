package com.example.leetcode.solution;

public class Solution1578 {

    public static void main(String[] args) {
        Solution1578 solution1578 = new Solution1578();

        String s = "cddcdcae";
        int[] cost = {4,8,8,4,4,5,4,2};
        int sum = solution1578.minCost(s, cost);
        System.out.println(sum);
    }


    public int minCost(String s, int[] cost) {

        if (s.length() < 2) return 0;

        int leftCur = 0;
        int sum = 0;
        // 查看周边有无一样的, 有的话就删除成本小的
        for (int i = 1; i < s.length(); i++) {

            char left = s.charAt(leftCur);

            char nowChar = s.charAt(i);
            if (nowChar == left) {
                //要删除一个
                if (cost[i] <= cost[leftCur]) {
                    // 删除小的
                    sum += cost[i];
                } else {
                    sum += cost[leftCur];
                    leftCur = i;  //左边的那个char,游标要移动到现在这个位置
                }
            }else {
                leftCur = i ;
            }
        }
        return sum;
    }
}

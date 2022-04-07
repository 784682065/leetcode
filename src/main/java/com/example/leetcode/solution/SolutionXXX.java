package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/4/7
 * @description:
 */
public class SolutionXXX {

    /**
     * 进行分裂
     * 2 块钱一瓶水,  4瓶盖换一瓶, 两个空瓶换一瓶
     * @param bottleNums 本次买水数
     * @param remainingBottles 剩余瓶子数目
     * @param bottleCap 剩余瓶盖数目
     * @param total 总共换水
     * @return 换水总数
     */
    public int cal(int bottleNums, int remainingBottles, int bottleCap, int total) {
        // 瓶子所能换的水
        int bottleWaterChange0 = (bottleNums + remainingBottles) / 2;
        // 瓶子余量
        remainingBottles = (bottleNums + remainingBottles) % 2;
        // 瓶盖所能换的水
        int bottleWaterChange1 = (bottleNums + bottleCap) / 4;
        // 瓶盖余量
        bottleCap = (bottleNums + bottleCap) % 4;
        int bchs = bottleWaterChange0 + bottleWaterChange1;
        total = bchs + total;
        // 如果还能换继续递归
        if (!(remainingBottles + bchs < 2 && bottleCap + bchs < 4)) {
            total = cal(bottleWaterChange0 + bottleWaterChange1, remainingBottles, bottleCap, total);
        }
        return total;
    }
    public static void main(String[] args) {
        SolutionXXX solutionFriday = new SolutionXXX();
        System.out.println(solutionFriday.cal(10 / 2, 0, 0, 10 / 2));
    }
}

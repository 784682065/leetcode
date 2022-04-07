package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/4/7
 * @description:
 */
public class Solution1518 {

    public int numWaterBottles(int numBottles, int numExchange) {

        return exchange(numBottles, numExchange, 0, numBottles);
    }

    public int exchange(int numBottles, int numExchange, int remainsBottles, int total) {

        // 可换瓶子
        int exchangeBottles = (numBottles + remainsBottles) / numExchange;
        // 剩余没换的瓶子
        remainsBottles = (numBottles + remainsBottles) % numExchange;

        total = total + exchangeBottles;
        if (remainsBottles + exchangeBottles >= numExchange) {
            total = exchange(exchangeBottles, numExchange, remainsBottles, total);
        }
        return total;
    }

    public int numWaterBottlesOffcial1(int numBottles, int numExchange) {
        int bottle = numBottles, ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }

    public int numWaterBottlesOffical2(int numBottles, int numExchange) {
        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }


    public static void main(String[] args) {
        Solution1518 solution1518 = new Solution1518();
        int i = solution1518.numWaterBottles(9, 3);
        System.out.println(i);
    }

}

package com.example.leetcode.solution;

public class Solution605 {


    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        Solution605 solution605 = new Solution605();
        boolean b = solution605.canPlaceFlowers(flowerbed, 1);
        System.out.println(b);
    }

    /**
     * 输入：flowerbed = [1,0,0,0,1], n = 1
     * 输出：true
     *
     * @param flowerbed 花坛
     * @param n 需要种植的数量
     * @return 是否能种下
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int zeroNum = 0;
        // 还要判断后面以为是不是 0
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (i - 1 == -1 || flowerbed[i - 1] == 0) {
                    zeroNum++;
                }

                if (i + 1 == flowerbed.length || flowerbed[i + 1] == 0) {
                    zeroNum++;
                }
            }

            if (zeroNum == 2) {
                n--;
                flowerbed[i] = 1;
            }

            zeroNum = 0;
            if (n <= 0) return true;
        }


        return false;
    }
}

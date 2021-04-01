package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-05-06 16:23
 */
public class Solution11 {

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int i = maxAreaDoublePointer(a);
        System.out.println(i);
    }

    /**
     * 考虑第一步，假设当前左指针和右指针指向的数分别为 xx 和 yy，不失一般性，我们假设 x \leq yx≤y。同时，两个指针之间的距离为 tt。那么，它们组成的容器的容量为：
     * <p>
     * \min(x, y) * t = x * t
     * min(x,y)∗t=x∗t
     * <p>
     * 我们可以断定，如果我们保持左指针的位置不变，那么无论右指针在哪里，这个容器的容量都不会超过 x * tx∗t 了。注意这里右指针只能向左移动，因为 我们考虑的是第一步，也就是 指针还指向数组的左右边界的时候。
     *
     * @param height
     * @return
     */
    public static int maxAreaDoublePointer(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;
        while (left != right) {

            int s = Math.min(height[left], height[right]) * (right - left);
            area = Math.max(s, area);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }

        }

        return area;
    }


    public int maxArea(int[] height) {

        int x;
        int y;
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                x = j - i;
                y = Math.min(height[i], height[j]);
                if (x * y > area) {
                    area = x * y;
                }
            }
        }


        return area;
    }

}

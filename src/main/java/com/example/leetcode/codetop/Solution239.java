package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution239 {

//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        int length = nums.length - k + 1;
//        int[] res = new int[length];
//        int resIndex = 0;
//
//        int l = 0, r = l + k - 1;
//        int maxIndex = -1;
//        int maxVal = Integer.MIN_VALUE;
//
//        int needRun = 0;
//        while (r < nums.length) {
//
//            for (int i = 0; i < needRun; i++) {
//                if (r + i >= nums.length) {
//                    r = r + i;
//                    break;
//                }
//                if (r + i < nums.length && nums[r + i] < maxVal) {
//                    res[resIndex++] = maxVal;
//                } else {
//                    // 找到比目前大的
//                    needRun = k;
//                    res[resIndex++] = maxVal;
//                    break;
//                }
//            }
//            // 如果跑完了还是原先的最大,又要找最大的
//            r = needRun + r;
//            l = r - k + 1;
//            for (int i = l; i < r && i < nums.length; i++) {
//                if (maxVal <= nums[i]) {
//                    maxIndex = i;
//                    maxVal = nums[i];
//                }
//            }
//            res[resIndex++] = maxVal;
//            needRun = maxIndex - l;
//        }
//
//        return res;
//    }

    class Pair{
        int val;
        int index ;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }


    // 使用队列构造递减数列. ,每次拿出头就好了, 如果头 位置 < l则丢弃,继续拿下一个大的.
    // 遇到大的就把前面小的全部抛弃.
    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] res = new int[nums.length - k + 1];
        PriorityQueue<Pair>  queue = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);

        for (int i = 0; i < k -1; i++) {
            queue.offer(new Pair(nums[i],i ));
        }
        int resIndex = 0;

        for (int i = k -1; i < nums.length; i++) {
            queue.offer(new Pair(nums[i],i ));
            while (queue.peek().index <  i - k +1){
                    queue.poll();
            }
            res[resIndex ++] =queue.peek().val;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Solution239 solution239 = new Solution239();
        int[] ints = solution239.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}

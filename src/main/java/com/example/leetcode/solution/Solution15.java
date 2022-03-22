package com.example.leetcode.solution;

import com.sun.deploy.util.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: hzp
 * @date: 2022/3/22
 * @description:
 */
public class Solution15 {

    /**
     * 排序加双指针
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同 , 且不是第一次被枚举
                // 因为如果不是第一次进入的这个second赋值的话,这个值只有可能找到了或者没找到,这两种情况都需要排除这个值了
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution15 solutio15 = new Solution15();
        int[] nums = {1, 2, -2, -1};
        List<List<Integer>> lists = solutio15.threeSum(nums);
        System.out.println(lists.toString());
    }


    public List<List<Integer>> myThreeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int k = length - 1;
            for (int j = i + 1; j < length - 1; j++) {
                if (j != (i + 1) && nums[j] == nums[j - 1]) {
                    continue;
                }

                while (j < k && nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                }

                if (k == j) {
                    break;
                }
                if (nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                }


            }

        }


        return ans;
    }

}

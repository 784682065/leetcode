package com.example.leetcode.solution;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution32 {

    public static void main(String[] args) {

        int[] nums = {5,1,3};
        int target = 5 ;
//        System.out.println(Arrays.toString(Arrays.copyOfRange(nums, 2, nums.length)));

        Solution32 solution32 = new Solution32();
        int search = solution32.search(nums, target);
        System.out.println(search);

    }


    public int searchOffical(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        //变向二分法
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     * 思路：如果中间的数小于最右边的数，则右半段是有序的，
     * 若中间数大于最右边数，则左半段是有序的，
     * 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，
     * 这样就可以确定保留哪半边了
     *
     * @param nums   数组
     * @param target 目标值
     * @return index
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int mid = (nums.length - 1) / 2;

        if (nums[mid] >= nums[0]) {
            //如果中间的数大于最左边的数, 则左半有序

            //若target在有序那部分里面,则二分查找
            if (target >= nums[0] && target <= nums[mid]) {
                nums =Arrays.copyOfRange(nums, 0, mid +1);
                return BinarySearch(nums, target);
            } else {
                if ( mid + 1 > nums.length ) return  -1;
                if (mid + 1 == 1 && nums.length ==1) return -1;


                nums =Arrays.copyOfRange(nums, mid +1, nums.length);
                //不然说明在右半 无序队列中
                int res = search(nums, target);
                return res == -1 ? -1 :  mid + res +1;
            }
        } else {
            //如果中间的数小于等于 最左边的数, 则右半有序
            if (target >= nums[mid] && target <= nums[nums.length - 1]) {
                nums =Arrays.copyOfRange(nums, mid , nums.length);
                int res = BinarySearch(nums, target);
                return res == -1 ? -1 : mid + BinarySearch(nums, target);
            } else {
                if ( mid - 1 < 0 ) return  -1;

                nums =Arrays.copyOfRange(nums, 0, mid);
                //不然说明在左半无序队列中
                return search(nums, target);
            }

        }
    }

    public static int BinarySearch(int[] arr, int target) {

        int low = 0, high = arr.length - 1, mid = (high + low) / 2;

        while (low <= high) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
            mid = (high + low) / 2;
        }
        return -1;
    }


}

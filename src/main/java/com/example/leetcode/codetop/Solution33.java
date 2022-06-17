package com.example.leetcode.codetop;

public class Solution33 {

    /**
     * 正常二分法搜索,在于mid 比target值, 大的话查询左边
     * 而这里的二分法, 还需要加入 [0] [mid] [len-1] 来判断target应该在哪一片
     * 还需要判断 [0]与[mid]的大小,从而找出有序的那一块, 去判断target 在无序的哪一块还是有序的那一块.
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0)
            return -1;
        if (len == 1) {
            return nums[0] == target ? 0 : -1;
        }

        int l = 0, r = len - 1;
        int mid;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 1. 找有序的哪一块, 要大于等于 不然数组只有两个数的时候, mid 等于l,会导致边界判断错误
            // 0和left可以达到一样的效果（就是确定mid左边是有序数组）。因为，如果mid右边是有序数组，那么nums[0]就会大于nums[mid],用反证法的思想来说
            if (nums[l] <= nums[mid]) {
                // 有序的一块在前半片
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                // 有序的是后面一半
                if (target > nums[mid] && target <= nums[len - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums ={3,1};
        Solution33 solution33 = new Solution33();
        int search = solution33.search(nums, 3);

        System.out.println(search);
    }
}

package com.example.leetcode.solution;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  11:22 2020/5/3
 * @param:
 */
public class Solution215 {

    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int kthLargest = solution215.findKthLargest(nums, k);
        System.out.println(kthLargest);
    }


    public int findKthLargest_(int[] nums, int k) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        // 转换一下，第 k 大元素的索引是 len - k
        int target = len - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index == target) {
                return nums[index];
            } else if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 在数组 nums 的子区间 [left, right] 执行 partition 操作，返回 nums[left] 排序以后应该在的位置
     * 在遍历过程中保持循环不变量的语义
     * 1、[left + 1, j] < nums[left]
     * 2、(j, i] >= nums[left]
     *
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

//    作者：liweiwei1419
//    链接：https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
















    public int findKthLargest(int[] nums, int k) {
        return findKthLargest1(nums, k - 1, 0, nums.length - 1);
    }

    /**
     * 减治法
     */
    public int findKthLargest1(int[] nums, int k, int start, int end) {


        //1. 找中间值 比她大的放左边，比她小的放右边，返回它的位置
        int p = getPosition(nums, start, end);

        if (p == k) {
            return nums[k];
        }

        int res;
        //说明需要找得值位于前方
        if (p > k) {
            res = findKthLargest1(nums, k, start, p);
        } else {
            res = findKthLargest1(nums, k, p + 1, end);
        }
        return res;
    }

    /**
     * 返回num 位置并且 给他nums 排序
     */
    private int getPosition(int[] nums, int start, int end) {

        while (start < end) {

            //左侧扫描
            while (start < end && nums[start] >= nums[end]) end--;
            if (nums[start] < nums[end]) {
                //交换两个 数位置
                int t = nums[end];
                nums[end] = nums[start];
                nums[start] = t;
                start++;
            }

            //右侧扫描
            while (start < end && nums[start] >= nums[end]) start++;
            if (nums[start] < nums[end]) {
                //交换两个 数位置
                int t = nums[end];
                nums[end] = nums[start];
                nums[start] = t;
                end--;
            }

        }

        return start;
    }
}
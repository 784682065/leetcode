package com.example.leetcode.codetop;

import java.util.Arrays;

/**
 * @author: hzp
 * @date: 2022/5/27
 * @description:
 */
public class Solution912 {

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);
        return nums;
    }


    private void quickSort(int[] nums, int low, int high) {

        if (low > high)
            return;
        int pos = partition(nums, low, high);
        quickSort(nums, low, pos - 1);
        quickSort(nums, pos + 1, high);

    }

    private int partition(int[] nums, int left, int right) {
        int ptr = left, x = nums[right];
        for (int i = left; i < right; i++) {
            if (x >= nums[i]) {
                swap(nums, ptr, i);
                ptr++;
            }
        }
        swap(nums, ptr, right);
        return ptr;
    }

    private void swap(int[] nums, int ptr, int i) {
        int temp = nums[ptr];
        nums[ptr] = nums[i];
        nums[i] = temp;
    }


    public void heapSort(int[] nums) {
        int len = nums.length;
        buildMaxHeap(nums, len);
        for (int i = len - 1; i >= 1; --i) {
            swap(nums, i, 0);
            // 记住len 变小, 这样才不会把先前最大的值在换上来.
            len -= 1;
            maxHeapify(nums, 0, len);
        }
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        //从最后一个父节点位置开始调整每一个节点的子树。数组长度为heasize，因此最后一个节点的位置为heapsize-1, -1 是因为从0 开始计算，所以父节点的位置为(heapsize-1-1)/2。
        for (int i = (heapSize - 1) / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    // todo 注意不需要两个子树都去换值, 只需要一个最大的子树去调整就好 , 不然会出现重复计算
    // 因为换下去一个值只会导致一边需要 调整, 如果量变都递归的话,会导致量变都调整,
    // 但是两边都调整是没有意义的. 因为建立大根堆只是找一个最大的值,只要能换到最大的值到上面就ok了
    public void maxHeapify(int[] a, int i, int heapSize) {      //调整当前结点和子节点的顺序。
        //left和right表示当前父节点i的两个左右子节点。
        int left = i * 2 + 1, right = i * 2 + 2, largest = i;
        //如果左子点在数组内，且比当前父节点大，则将最大值的指针指向左子点。
        if (left < heapSize && a[left] > a[largest]) {
            largest = left;
        }
        //如果右子点在数组内，且比当前父节点大，则将最大值的指针指向右子点。
        if (right < heapSize && a[right] > a[largest]) {
            largest = right;
        }
        //如果最大值的指针不是父节点，则交换父节点和当前最大值指针指向的子节点。
        if (largest != i) {
            swap(a, i, largest);
            //由于交换了父节点和子节点，因此可能对子节点的子树造成影响，所以对子节点的子树进行调整。
            maxHeapify(a, largest, heapSize);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 6, 8, 5, 9};
        Solution912 solution912 = new Solution912();
//        int[] ints = solution912.heapSort(nums);
//        System.out.println(Arrays.toString(ints));
    }

}

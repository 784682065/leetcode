package com.example.leetcode.codetop;

import java.util.Arrays;
import java.util.Random;

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
        Random random = new Random();
//        该方法的作用是生成一个随机的int值，该值介于[0,n)的区间，也就是0到n之间的随机int值，包含0而不包含n。
        int randomIndex = random.nextInt(right - left + 1) + left;
        swap(nums, right, randomIndex);
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


    /**
     * 建堆过程小顶堆为例:
     * 1. 初建堆, 从最后一个父节点开始,保证子节点均小于父节点,
     * 若是有大的则上移动,再倒数第二个父节点同样操作,移动导致下面子树改变,需要递归建堆
     *
     * 2. 重建堆, 经过第一步,最大的值已经在顶端,
     * 把顶端值和最后一个值做交换,开始从顶部做排序,递归所有子树把第二大的值换上来,在接着第二大的值和倒数第二个位置交换.
     * @param nums
     */
    public void heapSort(int[] nums) {
        int len = nums.length;
        buildMaxHeap(nums, len); //初建堆 ,构建小顶堆,初建要把大的放到最顶上
        for (int i = len - 1; i >= 1; --i) { //重建堆, 从最末尾开始把每个值换上来重新建堆
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
        int[] nums = {10,12,11,13,14};
        Solution912 solution912 = new Solution912();
        solution912.heapSort(nums);

        System.out.println(Arrays.toString(nums));
    }

}

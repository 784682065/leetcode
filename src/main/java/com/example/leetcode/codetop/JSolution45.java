package com.example.leetcode.codetop;

public class JSolution45 {
    public String minNumber(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                // 每次把最小的移动到前面去
                if (jugde(nums, j, j - 1)) {
                    // 如果j小j前面移动
                    swap(nums, j, j - 1);
                }
            }
        }

        StringBuilder res = new StringBuilder();
        for (int num : nums) {
            res.append(num);
        }

        return res.toString();
    }

    private void swap(int[] nums, int j, int i) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private boolean jugde(int[] nums, int j, int i) {
        String a = nums[j] + String.valueOf(nums[i]);
        String b = nums[i] + String.valueOf(nums[j]);
        return Long.parseLong(a) < Long.parseLong(b);
    }


    public String minNumberOF(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs)
            res.append(s);
        return res.toString();
    }

    void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while (i < j) {
            // String compareTo 可以比较两个String大小
            while ((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j)
                j--;
            while ((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j)
                i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }



    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};
        JSolution45 jSolution45 = new JSolution45();
        System.out.println(jSolution45.minNumberOF(arr));
    }


}

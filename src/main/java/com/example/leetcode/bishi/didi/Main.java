package com.example.leetcode.bishi.didi;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        Long[] arr = new Long[n];
        float sum = 0f;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            sum += arr[i];
        }
        Arrays.sort(arr);
        int left = 0, rihgt = arr.length - 1;
        while (true) {
            float avg = sum / (rihgt - left + 1);
            float bound = avg *  k;
            // 如果当前最大值的话, 需要删除值
            if (arr[rihgt] > bound) {
                // 说明最左边的值影响平衡,要踢出队列
                if (avg - arr[left] > arr[rihgt] - avg) {
                    left++;
                    sum = sum - arr[left];
                }else {
                    rihgt--;
                    sum = sum - arr[rihgt];
                }
            } else {
                break;
            }
        }
        System.out.println(rihgt - left + 1);
    }
}

package com.example.leetcode.bishi.redbook;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

//100
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt();
        long k= scanner.nextLong();
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        long res =0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (i != j && arr[i] * arr[j] >= k ){
                    ++res;
                }else {
                    break;
                }
            }
        }
        System.out.println(res*2);
    }
}

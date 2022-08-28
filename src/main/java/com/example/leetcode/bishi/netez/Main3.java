package com.example.leetcode.bishi.netez;

import java.util.Scanner;

//100
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int max = 0, maxSec= 0;

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
            if ( (i+1) % 2 ==1){
                max  = Math.max(max,nums[i]);
            }else {
                maxSec= Math.max(maxSec,nums[i]);
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            if ((i+1) % 2 ==1){
                sum  += (max - nums[i]);
            }else {
                sum  += (maxSec - nums[i]);
            }
        }

        //
        if (max == maxSec){
            sum+= (n/2);
        }

        System.out.println(sum);
    }

}

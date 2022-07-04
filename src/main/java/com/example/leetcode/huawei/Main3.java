package com.example.leetcode.huawei;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (scan.hasNext()){
            int res = 0;
            int bottleNums = scan.nextInt();
            if (bottleNums == 0) return;
            while (bottleNums>=3){
                // 换到的
                res = res + (bottleNums/3);
                bottleNums =  (bottleNums/3) + (bottleNums%3);
            }
            if (bottleNums == 2)
                res ++;
            System.out.println(res);
        }
    }
}

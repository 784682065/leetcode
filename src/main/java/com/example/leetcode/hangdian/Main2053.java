package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:07 2020/4/18
 * @param:
 */
public class Main2053 {
    /**
     * 这道题的意思是，有很多个灯泡一开始都是关着的，
     * 我们要输入灯泡数n，同时n也是我们对灯泡的操作总次数，
     * 每当第某个灯泡能整除第某次操作，即对这个灯泡做一次开关操作（从开到关或从关到开）。
     * 例，输入的数的1，即有一个灯泡和一次操作，把灯打开即可；输入的数为5，有5个灯泡从1开始编号，
     * 第一次操作，1~5都能被1整除，全打开，第二次操作，只有2和4能被2整除，对2,4灯泡操作，
     * 以此类推。注意，最终输入的数只有第n个灯泡的状态。一开始代码把所有的的灯都操作了一遍，
     * 按以往的开灯题来做，超时了……
     * 随后想到，既然只需要输入第n的灯泡的状态，那么只需要对第n个灯泡操作即可，因此并不需要列出其他灯泡对其操作。
     *
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while (sn.hasNext()) {
            int n = sn.nextInt();
            int res = 0; //初始全是零，即所有的灯初始全是关着的
            for (int i = 1; i <= n; i++) { //i表示次数
                //既然题目要求第n个，那我们每一次就至改变第n个的值
                if (n % i == 0) {
                    res = res ^ 1;
                }
            }
            System.out.println(res);
        }
        sn.close();
    }
}

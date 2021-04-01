package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:30 2020/4/18
 * @param:
 */
public class Main2037 {

    /*
     *贪心算法：想要在一天内看尽可能多的节目，寻找最优贪心策略
     *1.如果我们每次都选择开始时间最早的活动，不能得到最优解；
     *2.如果我们每次都选择持续时间最短的活动，不能得到最优解；
     *3.可以用数学归纳法证明，我们的贪心策略应该是每次选择结束时间最短的活动（按这种方法选择活动可以给未安排活动留下尽可能多的时间）
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                b[i] = scanner.nextInt();
            }
            /**
             *  最重要一步
             *  将所有区间按照右端点的大小（这里指结束时间），从小到大排列
             *  冒泡排序
             */
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (b[i] > b[j]) {
                        int temp = b[i];
                        b[i] = b[j];
                        b[j] = temp;
                        temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }
                }
            }
            //初始点
            int count = 1;
//            int aa = a[0];
            int bb = b[0];

            for (int i = 1; i < n; i++) {
                if (bb <= a[i]){
                    bb = b[i];
                    count ++;
                }
            }
            System.out.println(count);

        }

        scanner.close();


    }
}

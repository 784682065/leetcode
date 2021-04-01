package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-20 14:10
 */
public class Main2073 {

    /**
     * 先别急着看代码，把思路捋清楚。
     * ##首先题目是求两点的距离，我们可以先求出第一个点到原点的距离，再求出第二个点到原点的距离，然后两者相减即可，
     * 重要的是求出距离公式，就ok了。（注：这里的到原点距离是指中途所经过的所有线段的长度和，不是直接求到原点距离哦233别搞错了）
     * ##递推过程：可以发现，图中的线段长度除了（0，0）->（0，1）长度是1，其他的只有两种，
     * 一种是斜率为-1的线段，一种是斜率为-2的线段，分别可以用m=sqrt（(i-1) * (i - 1)+(i-1) * (i-1)）
     * 和n=sqrt（i * i+(i-1) * (i-1)）来表示，因为（0,0）->(0,i)的距离可以表示为
     * （0,0）->（0，i-1）+（0，i-1）->（i-1,0）+（i-1,0）->（0，i），自己看图走一遍就懂了，
     * 用f（i）表示（0,0）->(0,i)的距离，则（0,0）->（0，i-1）的距离为f（i-1），其中f（1）=1，而（0，i-1）->（i-1,0）即为m，
     * （i-1,0）->（0，i）即为n，于是每个y轴上的点（0，i）到原点距离的递推关系式就出来了：
     * f（i）=f（i-1）+m+n ；f(1)=1
     * 再观察图中的点，发现不在坐标轴上的点都有一个特点，就是同一条线上的x+y相等
     * 所以如果要求的是（x，i）到原点的距离的话，等价于求（0，x+i）到原点的距离即f（x+i）再加上x*sqrt（2.0）即可
     * （观察图就可以得到，横坐标每增加1，长度增加根号2，别说你看不出来233）实在不懂就举个例子，就明白了，实践出真知。
     * <p>
     * #综上：点（x，y）到原点的距离公式为d=f（x+y）+x*sqrt（2.0）
     * 原文链接：https://blog.csdn.net/qq_39473176/java/article/details/104946225
     */
    static double[] arrs;

    static {
        arrs = new double[202];
        arrs[0] = 0;
        arrs[1] = 1;
        //计算（0，i）的到原点距离
        for (int i = 2; i < arrs.length; i++) {
            double m = Math.sqrt(2 * Math.pow(i - 1, 2));
            double n = Math.sqrt((i * i) + (i - 1) * (i - 1));
            arrs[i] = arrs[i - 1] + m + n;
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();

            double distance1 = arrs[x1 + y1] + x1 * Math.sqrt(2.0);
            double distance2 = arrs[x2 + y2] + x2 * Math.sqrt(2.0);
            System.out.println(String.format("%.3f", Math.abs(distance2 - distance1)));
        }

        scanner.close();
    }


}

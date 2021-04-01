package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:05 2020/4/18
 * @param:
 */
public class Main2059 {

    /**
     * 先分析这道题：
     * 兔子到达终点的时间时固定的，因此只需要考虑乌龟了，
     * 乌龟骑电车和骑自行车的时间，然后计算，
     * 因为中间有N个充电站，可以看做N个点（到起点的点），
     * 加上起点和终点则是N+2的位置，这时我们dp，判断到每个点的最小时间，
     * 结果也就是第N+2个点的最短时间
     * <p>
     * 起点时间是0.这是必须的，然后往后面DP
     * <p>
     * 到第i个，就让j从0循环到i-1，依次代表从j站一直开到i站，这样得到到达i站所需要
     * <p>
     * 的最短时间。
     * <p>
     * 最后比较到达第n+2站(终点)的时间与兔子所花的时间就可以了。
     *
     * @param args
     */

    static int L;
    static int N, C, T;
    static int VR, VT1, VT2;
    static int p[] = new int[102];
    static double dp[] = new double[105];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            L = scanner.nextInt(); // 跑道长度

            N = scanner.nextInt(); // 充电站个数
            C = scanner.nextInt(); //电动车行驶距离
            T = scanner.nextInt(); //充电所需时间

            VR = scanner.nextInt(); // 兔子速度
            VT1 = scanner.nextInt(); //乌龟开车速度
            VT2 = scanner.nextInt(); //脚踩电动车速度

            p[0] = 0;
            p[N + 1] = L;
            for (int i = 1; i <= N; i++) {
                p[i] = scanner.nextInt();
            }

            dp();
            if (1.0 * L / VR < dp[N + 1])
                System.out.println("Good job,rabbit!");
            else
                System.out.println("What a pity rabbit!");
        }

    }

    /**
     * 状态：
     * d[i]表示起点到第i个站点的最小时间
     * 起点为d[1]
     * 终点为d[n+1]
     * 中间是n个充电站
     * 状态转移方程：
     * d[i]=min(d[j]+t(j,i))        (0<=j<i)
     * t(j,i)表示第j站到i站的时间
     * 边界：
     * d[0]=0
     */
    static void dp() {
        double ans, min;
        for (int i = 0; i < 105; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        /**
         * 计算j点到i点的最短所需话费最短时间
         */
        for (int i = 1; i < N + 2; i++) {
            min = 100000;
            for (int j = 0; j < i; j++) {
                int len = p[i] - p[j];
                if (len > C) {
                    ans = 1.0 * C / VT1 + (len - C + 0.0) / VT2;      //如果电量不能达到j到i的距离
                } else {
                    ans = 1.0 * len / VT1;
                }
                ans += dp[j];     //d[j]中是 到j站点最短时间
                if (j != 0){
                    ans += T;     //过充电站，加上充电时间　
                }
                if (min > ans)
                    min = ans;
            }
            dp[i] = min;
        }
    }
}
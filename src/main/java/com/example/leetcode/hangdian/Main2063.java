package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  13:50 2020/4/19
 * @param:
 */
public class Main2063 {

    /**
     * 匈牙利算法 https://blog.csdn.net/pku_coder/article/details/53701327
     * 介绍完匈牙利算法，就讲讲在本题中如何应用的思路（其实这一题就是经典的匈牙利算法，都不用怎么变动的）
     * <p>
     * 1.先将数据接收
     * <p>
     * 创建一个used数组（用于在匈牙利算法中标记改人是否已经被查找过——也就是说选搭档的顺序只能顺着候选人往下，
     * 不能回头）
     * 创建一个boy数组（用于记录每一次的搭档情况）
     * 创建relation二维数组（用于存储女生期望搭档的映射图）
     * 2.开始扫描每一个女生，每个女生都通过一次匈牙利算法，如果返回为true，
     * 这说明可以腾出位置，则结果加一，
     * 否则接着循环（注：在一个女生结束之后，将used数组回溯，便于下一次查找）
     *
     * @param args
     */
    private static int[][] relation_pic;
    private static int[] used;
    private static int[] boy;
    private static int K, M, N; //k 愿意组合的对数, M女生人数 N男生人数

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            K = scanner.nextInt();
            if (K == 0) break;


            M = scanner.nextInt();
            N = scanner.nextInt();


            relation_pic = new int[M + 1][N + 1];
            for (int i = 0; i < K; i++) {
                relation_pic[scanner.nextInt()][scanner.nextInt()] = 1;
            }
            used = new int[N + 1];
            boy = new int[N + 1];

            int count = 0;
            for (int i = 1; i <= M; i++) {
                for (int j = 1; j <= N; j++) {
                    //每次为某个女生找对象时候,表示每个男生可用
                    used[j] = 0;
                }
                if (find(i)) {
                    count++;
                }
            }

            System.out.println(count);

        }
        scanner.close();
    }

    private static boolean find(int gn) {

        for (int i = 1; i <= N; i++) {
            if (used[i] == 0 &&   //男性不能被使用过,保证每次一个妹子进来都是按照顺序选下去
                    relation_pic[gn][i] == 1 //女性要对该男性有意思
            ) {
                used[i] = 1; // 标记该男性已经被使用过
                if (boy[i] ==0 ||  // 该男性没对象
                    find(boy[i])   //可以将该男性的对象转让给别人
                ) {
                    boy[i] = gn; //设置该男性对象为该女性
                    return true;
                }
            }
        }

        return false;
    }

}

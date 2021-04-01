package com.example.leetcode.hangdian;


import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  15:41 2020/4/19
 * @param:
 */
public class Main2066 {


    /**
     * 运行 WA不知道为什么
     * 参考 https://blog.csdn.net/libin56842/article/details/16919583
     * @param args
     */
    static int[][] city_dis; //城市距离
    static int[] ngb_city; //相邻的城市
    static int[] dream_city; //想去的地方
    static int N = 501;  //初始化地图大小
    static int T, S, D;
    static int a, b, time;
    static int n = 0; //最大的城市的编号
    static int[] vis ;
    static int[] cast ; //去城市的最短时间
    static int inf = 1 << 30;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            T = scanner.nextInt();
            S = scanner.nextInt();
            D = scanner.nextInt();

            begin(scanner); //初始化地图

            int minn = inf;

            Diskstra();

            for (int i = 0; i < D; i++) {
                minn = Math.min(minn, cast[dream_city[i]]);
            }
            System.out.println(minn);
        }
    }

    /**
     * Diskstra
     */
    private static void Diskstra() {
        int minn, pos = 0;
        vis[0] = 1;


        for (int i = 0; i <= n; i++) {
            cast[i] = city_dis[0][i];  //拿到小草家 去 周边城市的花费
        }

        for (int i = 1; i <= n; i++) { //每运行一次找到一个最小花费没有被访问过的最小花费的城市
            minn = inf;
            for (int j = 1; j <= n; j++) {   //找到一个代价最小的,并且记录该点
                if (cast[j] < minn && (vis[j] == 0)) { //如果到j花费的时间小于minn 且 j城市未曾去过
                    pos = j;   //到j
                    minn = cast[j];   //记录到j的花费
                }
            }

            vis[pos] = 1; //设置为去过该城市
            for (int j = 1; j <= n; j++) {
                if (cast[pos] + city_dis[pos][j] < cast[j] && (vis[j] == 0)) //如果经过中转点 小于原先到j城市的花费则更新该城市
                    cast[j] = cast[pos] + city_dis[pos][j];
            }

        }

    }

    static void begin(Scanner scanner) {

        //初始化地图
        city_dis = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    city_dis[i][j] = 0;
                } else {
                    city_dis[i][j] = inf;  // 默认为最大
                }
            }
        }

        //存边
        for (int i = 0; i < T; i++) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            time = scanner.nextInt();

            n = Math.max(Math.max(n, a), b);

            if (city_dis[a][b] > time) {
                city_dis[a][b] = time;
                city_dis[b][a] = time;
            }
        }

        ngb_city = new int[S];
        for (int i = 0; i < S; i++) {
            ngb_city[i] = scanner.nextInt();     //边上的城市
            city_dis[0][ngb_city[i]] = city_dis[ngb_city[i]][0] = 0; //设置到周边城市距离为0
        }

        dream_city = new int[D];
        for (int i = 0; i < D; i++) {
            dream_city[i] = scanner.nextInt();
        }

        vis= new int[501];
//        for (int i = 0; i <= 500; i++) { //默认没去过任何一个城市
//            vis[i] = 0;
//        }
        cast = new int[501];
        for (int i = 0; i <= 500; i++) { // 默认花费最大值
            cast[i] = inf;
        }
    }
}

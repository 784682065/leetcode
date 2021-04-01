package com.example.leetcode.algorithm;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:39 2020/5/4
 * @param:
 */
public class DijstraAlgorithm {
    //不能设置为Integer.MAX_VALUE，否则两个Integer.MAX_VALUE相加会溢出导致出现负权
    public static int MaxValue = 100000;

    /**
     * 问：为什么迪杰斯特拉算法只支持非负权的图？
     *
     * 答：迪杰斯特拉采用的贪心策略，S集合中是已经计算出最短路径的节点，T集合中是未计算出最短路径的节点。假设存在负权，源点为A，已经计算出A->B的最短路径为m，若下一次将C添加进已计算出最短路径的节点集合，而A->C=m，C->B=-1，则会出现A->B的更短路径A->C->B，但迪杰斯特拉不会对已经计算出最短路径的节点重新计算，因此无法更新最短路径，即负权的出现导致无法保证S中节点计算的是最短路径，已经固定dis的点可能会被其它dis大于它的点更新。
     *
     * 问：为什么在代码实现中不能将节点之间不可达用Integer.MAX_VALUE代表？
     *
     * 答：因为两个Integer.MAX_VALUE相加会溢出导致出现负权，所以最好设置为一个比较大且不容易相加溢出的数。
     *
     * 问：迪杰斯特拉算法适用于什么场景？
     *
     * 答：在有些算法书上说，迪杰斯特拉适用于DAG（有向无环图）。但是个人觉得，它所谓的“适用于”，或许只是说可以在DAG上使用，并不代表无向图不能使用，也不能代表有环图不能使用。从迪杰斯特拉的算法原理上来说，无向图是没有问题的，只需要给matrix[source][target]和matrix[target][source]赋上相同的权值，因为它每次只会根据到源点的距离，选取距离最近的一个节点加入，所以有没有方向都无所谓，算法只关注可达点的距离；至于有环图，它对每个节点的距离计算只用了一层遍历去做，并不会陷入死循环，也不会出现重复计算的问题。因此迪杰斯特拉算法是可以用在无向图和有环图中的，适合于求单源最短路径。
     * ————————————————
     * 版权声明：本文为CSDN博主「廿半」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * @param args
     */

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入顶点数和边数:");
        //顶点数
        int vertex = input.nextInt();
        //边数
        int edge = input.nextInt();

        int[][] matrix = new int[vertex][vertex];
        //初始化邻接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MaxValue;
            }
        }
        for (int i = 0; i < edge; i++) {
            System.out.println("请输入第" + (i + 1) + "条边与其权值:");
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }

        //单源最短路径，源点
        int source = input.nextInt();
        //调用dijstra算法计算最短路径
        dijstra(matrix, source);
    }

    public static void dijstra(int[][] matrix, int source) {
        //最短路径长度
        int[] shortest = new int[matrix.length];
        //判断该点的最短路径是否求出
        int[] visited = new int[matrix.length];
        //存储输出路径
        String[] path = new String[matrix.length];

        //初始化输出路径
        for (int i = 0; i < matrix.length; i++) {
            path[i] = new String(source + "->" + i);
        }

        //初始化源节点
        shortest[source] = 0;
        visited[source] = 1;

        for (int i = 1; i < matrix.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;

            for (int j = 0; j < matrix.length; j++) {
                //已经求出最短路径的节点不需要再加入计算并判断加入节点后是否存在更短路径
                if (visited[j] == 0 && matrix[source][j] < min) {
                    min = matrix[source][j];
                    index = j;
                }
            }

            //更新最短路径
            shortest[index] = min;
            visited[index] = 1;

            //更新从index跳到其它节点的较短路径
            for (int m = 0; m < matrix.length; m++) {
                if (visited[m] == 0 && matrix[source][index] + matrix[index][m] < matrix[source][m]) {
                    matrix[source][m] = matrix[source][index] + matrix[index][m];
                    path[m] = path[index] + "->" + m;
                }
            }

        }

        //打印最短路径
        for (int i = 0; i < matrix.length; i++) {
            if (i != source) {
                if (shortest[i] == MaxValue) {
                    System.out.println(source + "到" + i + "不可达");
                } else {
                    System.out.println(source + "到" + i + "的最短路径为：" + path[i] + "，最短距离是：" + shortest[i]);
                }
            }
        }
    }
}
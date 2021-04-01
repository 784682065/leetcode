package com.example.leetcode.algorithm;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:55 2020/5/2
 * @param:
 */
public class Prime {


    public static void main(String[] args) {
        int inf = 1000000;//无穷大
        //图，可以这样认为：图的任意两个顶点之间都有边，两顶点无法到达的，可以认为他们之间的边权是无穷大
        int[][] graph = {
                {inf, 6, 1, inf},
                {6, inf, 5, 3},
                {1, 5, inf, 4},
                {inf, 3, 4, inf}
        };
        boolean[] visited = new boolean[4];
        ;
        for (int i = 0; i < 4; i++) {
            visited[i] = false;
        }

        int index = 0;
        int sum = 0;
        int[] distance = new int[4];
        visited[0] = true;//从1这个顶点开始
        //初始化 从顶点0 开始
        for (int i = 0; i < 4; i++) {
            distance[i] = graph[0][i];
        }
        //由于已经访问过一个节点了，剩下3个节点，每次能找好一个节点，最多再找3次
        for (int i = 0; i < 3; i++) {
            int minimum = inf;
            //从所有没有访问的节点中找一个到已经访问的节点距离最小的
            for (int j = 0; j < 4; j++) {
                if (visited[j] == false && distance[j] < minimum) {
                    minimum = distance[j];
                    index = j;
                }
            }
            visited[index] = true;
            sum += minimum;
            //更新距离，上面又新产生了一个访问过的节点，现在更新所有未访问节点 , 就比如 0 去过 1 , 那么可以更新 1 到所有结点的距离
            //到所有已经访问节点的最小距离
            for (int j = 0; j < 4; j++) {
                if (visited[j] == false && distance[j] > graph[index][j]) {
                    distance[j] = graph[index][j];
                }
            }
        }
        System.out.println(sum);
    }


}

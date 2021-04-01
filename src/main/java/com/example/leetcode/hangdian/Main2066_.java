package com.example.leetcode.hangdian;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  18:52 2020/4/19
 * @param:
 */
public class Main2066_ {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (scn.hasNext()) {
            int pointsNumber = 1002;
            int edgesNumber = Integer.parseInt(scn.next());
            int startNumber = Integer.parseInt(scn.next());
            int endNumber = Integer.parseInt(scn.next());
            Dijkstra dijkstra = new Dijkstra(pointsNumber);

            //插入城市a -> b 的 路径 双向
            for (int i = 0; i < edgesNumber; ++i) {
                int start = Integer.parseInt(scn.next());
                int end = Integer.parseInt(scn.next());
                int distance = Integer.parseInt(scn.next());
                dijkstra.addEdge(start, end, distance);
                dijkstra.addEdge(end, start, distance);
            }


            int initStart = 0;
            int initEnd = 1001;
            //与家相连的城市
            for (int i = 0; i < startNumber; ++i) {
                int start = Integer.parseInt(scn.next());
                dijkstra.addEdge(initStart, start, 0);
            }

            //想去的点
            for (int i = 0; i < endNumber; ++i) {
                int end = Integer.parseInt(scn.next());
                dijkstra.addEdge(end, initEnd, 0);
            }
            int distance = dijkstra.calculateDistance(initStart, initEnd);

            if (dijkstra.hasMinDistance()) {
                System.out.println(distance);
            } else {
                System.out.println("-1");
            }
        }
        scn.close();
    }

}

class Dijkstra {

    private final int INF = Integer.MAX_VALUE / 2;
    private int pointsNumber;
    private int[][] matrix;
    private boolean[] visit;
    private int[] resultDistance;
    private int resultMinDistance;

    public Dijkstra(int pointsNumber) {
        this.pointsNumber = pointsNumber;
        matrix = new int[pointsNumber][pointsNumber];
        for (int i = 0; i < pointsNumber; ++i) {
            Arrays.fill(matrix[i], INF);
            matrix[i][i] = 0;
        }
        visit = new boolean[pointsNumber];
        resultDistance = new int[pointsNumber];
        resultMinDistance = INF;
    }

    public void addEdge(int start, int end, int distance) {
        if (matrix[start][end] > distance) {
            matrix[start][end] = distance;
        }
    }

    public int calculateDistance(int initStart, int initEnd) {
        Arrays.fill(visit, false);
        //起点为true
        visit[initStart] = true;

        //resultDistance 地图上从起点开始到某点的结果集
        for (int i = 0; i < pointsNumber; ++i) {
            resultDistance[i] = matrix[initStart][i];
        }

        //
        for (int i = 0; i < pointsNumber; ++i) {
            int minDistance = INF;
            int minPoint = -1;
            for (int j = 0; j < pointsNumber; ++j) {
                if (!visit[j] && resultDistance[j] < minDistance) {
                    minDistance = resultDistance[j];
                    minPoint = j;
                }
            }

            if (-1 == minPoint || minPoint == initEnd) {
                break;
            }

            visit[minPoint] = true;

            for (int j = 0; j < pointsNumber; ++j) {
                if (!visit[j]   //j点未访问到
                        && resultDistance[j] > resultDistance[minPoint] + matrix[minPoint][j]  //结果集j城距离 大于 距离最小点到j
                ) {

                    resultDistance[j] = resultDistance[minPoint] + matrix[minPoint][j];

                }
            }

        }
        //因为resultDistance[initEnd] 到 想去的城市的点距离为0,所以 最小距离会写到 resultDistance[initEnd] 中
        resultMinDistance = resultDistance[initEnd];
        return resultDistance[initEnd];
    }

    public boolean hasMinDistance() {
        if (INF <= resultMinDistance) {
            return false;
        } else {
            return true;
        }
    }

}


package com.example.leetcode.algorithm;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:18 2020/5/4
 * @param:
 */
public class Floyd {



    public static void main(String[] args) {
        // write your code here
        //下面是相邻结点之间的路程表。-1代表不可达，
        // 一般来说这个值用int的maxvalue来代替，
        // 但是这个值是有可能被达到的所以我不用这
        // 种方式。而具有现实意义的值只能是自然数
        // ，所以负数是永远不可达的，所以不可达指
        // 定为-1.
        int[][] distanceMatrix = {
                {0,2,6,4},
                {-1,0,3,-1},
                {7,-1,0,1},
                {5,-1,12,0}
        };
        int[][] distanceMatrix0 = {
                {0,4,11},
                {6,0,2},
                {3,-1,0}
        };
        int[][] distanceMatrix1 = {
                {0,-1,10,-1,30,100},
                {-1,0,5,-1,-1,-1},
                {-1,-1,0,50,-1,-1},
                {-1,-1,-1,0,-1,10},
                {-1,-1,-1,20,0,60},
                {-1,-1,-1,-1,-1,0}
        };
        Floyd.floyd0(distanceMatrix);
    }
    /**
     * 多元最短路径问题之
     * 弗洛伊德算法
     * 本算法的中心思想是
     * 任何2个结点之间的
     * 路程可以通过其他结
     * 点的介入缩短。通过
     * 不断尝试让其他结点
     * 介入以找出更短的路
     * 程。
     * 它最后输出的是一个数值
     * 就是某一点到另外一个点
     * 的最短的路程，并不是最短
     * 路径上面所经过的结点。
     * 它所适用的图是有向图。
     * 并且权值不能为负。
     * @param distanceMatrix
     */
    static public void floyd0(int[][] distanceMatrix) {
        int arrayLength = distanceMatrix.length;
        //为了不改变原来原来的输入矩阵，这里把它复制过来。
        // 顺便找出最大值
        int[][] copyedMatrix = new int[arrayLength][arrayLength];
        //用来输出路径的矩阵，
        // 随着矩阵的更新，那
        // 么最后得到的就是2
        // 个点经过n个点能够
        // 达到最小路径，但是
        // 这n个点的顺序无从
        // 得知。所以还有一个
        // 查找的过程。
        int[][] pathMatrix = new int[arrayLength][arrayLength];
        int maxValue = 0;
        for (int counter0 = 0;counter0 < arrayLength;counter0++) {
            for (int counter1 = 0;counter1 < arrayLength;counter1++) {
                copyedMatrix[counter0][counter1] = distanceMatrix[counter0][counter1];
                pathMatrix[counter0][counter1] = -1;
                if (copyedMatrix[counter0][counter1] > maxValue)
                    maxValue = copyedMatrix[counter0][counter1];
            }
        }
        maxValue++;
        //现在假设要的是从顶点one到another经过middle来达到最短路径。
        // 每经过一个中间点就更新一遍邻接矩阵。
        // 为啥middle不能放在内层循环呢？
        // 那样的话意思就是某两点之间通过哪
        // 个点为中介路程会更短。那么一趟内
        // 循环下来会得到某两个点之间通过哪
        // 个点能够达到更短的路程。并且这个
        // 中间点是不断被更新的，最后得到结
        // 果就是指定两个点在只插入一个点的
        // 情况下达到路程最小。显然这样得到
        // 的最小并不是本算法的初衷，因为对
        // 于输入的两个点之间可没有至多插入
        // 一个点，这种限制。而正确的算法之
        // 所以这样实现是想在经过某个点的2
        // 个输入点在当前插入点的情况下达到
        // 最小，这个有点类似于递归，那就是
        // 当前的最优解是基于以前的解都是最
        // 优解的基础上而言的。
        for (int middleVertex = 0;middleVertex < arrayLength;middleVertex++){
            for (int oneVertex = 0;oneVertex < arrayLength;oneVertex++) {
                for (int anotherVertex = 0;anotherVertex < arrayLength;anotherVertex++) {
                    if (oneVertex != anotherVertex) {
                        //跳过自身，自身到自身毫无意义。
                        if (copyedMatrix[oneVertex][anotherVertex] < 0)
                            copyedMatrix[oneVertex][anotherVertex] = maxValue;
                        if (copyedMatrix[oneVertex][middleVertex] < 0)
                            copyedMatrix[oneVertex][middleVertex] = maxValue;
                        if (copyedMatrix[middleVertex][anotherVertex] < 0)
                            copyedMatrix[middleVertex][anotherVertex] = maxValue;
                        if (copyedMatrix[oneVertex][anotherVertex] > copyedMatrix[oneVertex][middleVertex] + copyedMatrix[middleVertex][anotherVertex]) {
                            copyedMatrix[oneVertex][anotherVertex] = copyedMatrix[oneVertex][middleVertex] + copyedMatrix[middleVertex][anotherVertex];
                            pathMatrix[oneVertex][anotherVertex] = middleVertex;
                        }
                    }
                }
            }
        }
        //经过这样一来，已经全部是最短路径了，现在可以把它打印出来看看
        System.out.println("最短路程矩阵");
        for (int counter0 = 0;counter0 < arrayLength;counter0++) {
            for (int counter1 = 0;counter1 < arrayLength;counter1++) {
                System.out.print(copyedMatrix[counter0][counter1] + " ");
            }
            System.out.println();
        }
        //每2个点之间经过的中间点，现在可以把它打印出来看看
        System.out.println("\n中间结点矩阵");
        for (int counter0 = 0;counter0 < arrayLength;counter0++) {
            for (int counter1 = 0;counter1 < arrayLength;counter1++) {
                System.out.print(pathMatrix[counter0][counter1] + " ");
            }
            System.out.println();
        }
        //现在打印每对输入结点的中间结点序列，
        // 假设数组中有n个结点，
        // 从栈的变化来看树的深
        // 度最多为n-1层，因为
        // 源点和终点不同。又因
        // 为叶子结点那一层是2
        // 个，所以结点个数n-1+1=n。
        // 因为栈中二叉树的结点
        // 是点对，所以需要乘以
        // 2才行，得出总共最多需
        // 要2n个存储空间。
        int[] nodeStack = new int[2 * arrayLength];
        for (int counter0 = 0;counter0 < arrayLength;counter0++) {
            for (int counter1 = 0;counter1 < arrayLength;counter1++) {
                if (counter0 != counter1) {
                    System.out.print("从" + counter0 + "到" + counter1 + "路径为:");
                    if (copyedMatrix[counter0][counter1] == maxValue)
                        System.out.println("无");
                    else {
                        System.out.print(counter0);
                        int nodeStackTopPointer = -1;
                        nodeStack[++nodeStackTopPointer] = counter0;
                        nodeStack[++nodeStackTopPointer] = counter1;
                        while (nodeStackTopPointer > -1) {
                            int targetNode = nodeStack[nodeStackTopPointer--];
                            int sourceNode = nodeStack[nodeStackTopPointer--];
                            if (-1 == pathMatrix[sourceNode][targetNode]) {
                                System.out.print("-->" + targetNode);
                            } else  {
                                nodeStack[++nodeStackTopPointer] = pathMatrix[sourceNode][targetNode];
                                nodeStack[++nodeStackTopPointer] = targetNode;
                                nodeStack[++nodeStackTopPointer] = sourceNode;
                                nodeStack[++nodeStackTopPointer] = pathMatrix[sourceNode][targetNode];
                            }
                        }
                        System.out.println();
                    }
                }
            }
            System.out.println();
        }
    }
}

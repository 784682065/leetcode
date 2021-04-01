package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-17 8:33
 */
public class Main2023 {
    /**
     * 假设一个班有n(n<=50)个学生，每人考m(m<=5)门课，求每个学生的平均成绩和每门课的平均成绩，
     * 并输出各科成绩均大于等于平均成绩的学生数量。
     * <p>
     * 输入数据有多个测试实例，每个测试实例的第一行包括两个整数n和m，
     * 分别表示学生数和课程数。然后是n行数据，每行包括m个整数（即：考试分数）。
     * <p>
     * 对于每个测试实例，输出3行数据，第一行包含n个数据，表示n个学生的平均成绩，结果保留两位小数；第二行包含m个数据，
     * 表示m门课的平均成绩，结果保留两位小数；第三行是一个整数，表示该班级中各科成绩均大于等于平均成绩的学生数量。
     * 每个测试实例后面跟一个空行。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        while (sn.hasNext()) {
            // 学生数和课程数
            int n = sn.nextInt();
            int m = sn.nextInt();

            // 一个用来存学生的平均成绩
            double[] stuAvg = new double[n];
            // 一个用来存科目的平均成绩
            double[] gradeAvg = new double[m];

            // 然后是n行数据，每行包括m个整数（即：考试分数）
            // 第一个学生的两门考试分数； 第二个学生的两门考试分数
            double[][] arr = new double[n][m];
            for (int i = 0; i < n; i++) {
                double stuAv = 0;
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sn.nextDouble();
                    stuAv = stuAv + arr[i][j];
                }
                stuAvg[i] = stuAv / m;
            }
            for (int i = 0; i < n - 1; i++) {
                System.out.print(String.format("%.2f", stuAvg[i]) + " ");
            }
            System.out.println(String.format("%.2f", stuAvg[n - 1]));

            for (int i = 0; i < m; i++) {
                double gradeAv = 0;
                for (int j = 0; j < n; j++) {
                    gradeAv = gradeAv + arr[j][i];
                }
                gradeAvg[i] = gradeAv / n;
            }
            for (int i = 0; i < m - 1; i++) {
                System.out.print(String.format("%.2f", gradeAvg[i]) + " ");
            }
            System.out.println(String.format("%.2f", gradeAvg[m - 1]));

            int count = 0; // 统计分数高于平均科目成绩的人数
            for (int i = 0; i < n; i++) {
                boolean flag = true;
                for (int j = 0; j < m; j++) {
                    if (arr[i][j] < gradeAvg[j])
                        flag = false;
                }
                if (flag == true)
                    count++;
            }
            System.out.println(count);
            System.out.println(); //空行
        }

    }
}

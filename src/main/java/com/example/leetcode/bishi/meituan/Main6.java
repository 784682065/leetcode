package com.example.leetcode.bishi.meituan;

import java.util.Scanner;

public class Main6 {
    // w , s , a , d
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int k = Integer.parseInt(s1[2]);

        boolean[][] used = new boolean[n][m];
        int startRow = 0, startClo = 0;
        used[startRow][startClo] = true;
        int total = n*m -1;
        int res = 0;
        String commands = scanner.nextLine();
        for (int i = 0; i < k; i++) {
           char command = commands.charAt(i);
            switch (command) {
                case ('W'):
                    startRow += dir[0][0];
                    startClo += dir[0][1];
                    break;
                case ('S'):
                    startRow += dir[1][0];
                    startClo += dir[1][1];
                    break;
                case ('A'):
                    startRow += dir[2][0];
                    startClo += dir[2][1];
                    break;
                case ('D'):
                    startRow += dir[3][0];
                    startClo += dir[3][1];
                    break;
            }
            if (!used[startRow][startClo]){
                used[startRow][startClo] = true;
                --total;
                if (total == 0){
                    //命令个数
                    res = i +1;
                    break;
                }
            }
        }
        if (total == 0){
            System.out.println("Yes");
            System.out.println(res);
        }else {
            System.out.println("No");
            System.out.println(total);
        }


    }


}

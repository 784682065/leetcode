package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  9:33 2020/4/19
 * @param:
 */
public class Main2061 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-- > 0){
            int k = scanner.nextInt();

            double sumC = 0;
            double sumS = 0;
            boolean flag = true;
            for (int i = 0; i < k; i++) {
                scanner.next();
                double c = scanner.nextDouble();
                sumC =sumC + c;
                double score = scanner.nextDouble();
                if (score < 60){
                    flag = false;
                }
                sumS =sumS + c*score;
            }
            if (flag){
                System.out.println(String.format("%.2f", sumS/sumC));
            }else {
                System.out.println("Sorry!");
            }
            if(n>0){
                System.out.println("");
            }
        }

    }
}

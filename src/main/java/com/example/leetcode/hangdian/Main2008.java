package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:10 2020/4/15
 * @param:
 */
public class Main2008 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext() ){
            int n = scanner.nextInt();
            if (n == 0) {
                System.out.println("0") ;
                continue;
            }
            int nn =0; int  pn =0 ; int zero = 0;
            for (int i = 0; i < n; i++) {
                double val = scanner.nextDouble();
                if(val >0){
                    pn++;
                }else if ( val == 0){
                    zero ++;
                }else {
                    nn ++;
                }
            }
            System.out.println(nn + " " + zero + " " +pn);
        }
    }
}

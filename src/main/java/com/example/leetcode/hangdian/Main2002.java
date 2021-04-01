package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  23:12 2020/4/14
 * @param:
 */
public class Main2002 {

    static Double PI= 3.1415927;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double result;
        while(sc.hasNext()){
            double r = sc.nextDouble();
            result = ((double) 4/3)*PI * (r*r*r) ;
            System.out.printf( "%.3f\r\n",  result);

        }


    }
}

package com.example.leetcode.hangdian;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:44 2020/4/14
 * @param:
 */
public class Main2000 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(input.hasNext()){
            String str = input.next();
            char []arr;
            arr = order(str);
            for(int i=0; i<arr.length; ++i){
                if(i!=arr.length-1)
                    System.out.print(arr[i]+" ");
                else
                    System.out.println(arr[i]);
            }
        }
    }

    public static char[]order(String str){
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        return ch;
    }
}

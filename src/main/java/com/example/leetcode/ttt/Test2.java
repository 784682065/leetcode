package com.example.leetcode.ttt;

import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("=");
        if (split.length !=2){
            System.out.println("false");
            return;
        }
        System.out.println(checkFirst(split[0]) && checkSec(split[1]));
    }
    private static boolean checkFirst(String s) {
        if (s.length()!=1)
            return false;
       return Character.isLowerCase(s.charAt(0));
    }
    private static boolean checkSec(String s) {
        if (s.startsWith(" ")){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (!(Character.isLowerCase(charAt)  || charAt == ' ' || Character.isDigit(charAt) )){
                return false;
            }
        }
        return true;
    }
}

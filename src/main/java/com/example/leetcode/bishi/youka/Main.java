package com.example.leetcode.bishi.youka;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() -i -1)){
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }
}

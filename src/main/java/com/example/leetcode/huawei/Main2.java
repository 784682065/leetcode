package com.example.leetcode.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner scan = new Scanner(System.in);
//            Who Love Solo
//            Who
        if (scan.hasNextLine()) {
            String str = scan.nextLine();
            if (str.isEmpty()){
                System.out.println(0);
            }else {
                Set<Character> set = new HashSet<>();

                int total = 1;
                for (int i = 1; i <= str.length(); i++) {
                    total *= i;
                    set.add(str.charAt(i-1));
                }

                int num = 1 << (str.length() - set.size());
                System.out.println(total / num);
            }

        }


    }
}


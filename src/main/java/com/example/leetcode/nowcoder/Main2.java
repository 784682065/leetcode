package com.example.leetcode.nowcoder;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        if (scanner.hasNextLine()) {
        int i = Integer.parseInt(scanner.nextLine());
        for (int j = 0; j < i; j++) {
            String s = scanner.nextLine();
            check(s);
        }
//        }


    }


//    public static void main(String[] args) throws Exception{
//        Scanner sc = new Scanner(System.in);
//        int N = Integer.parseInt(sc.nextLine());
//        while(N-- > 0){
//            String str = sc.nextLine();
//            StringBuilder s = new StringBuilder(str);
//            for(int i = 0; i + 2 < s.length(); ++i){
//                char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
//                if(a == b && b == c) s.deleteCharAt(i--);
//            }
//            for(int i = 0; i + 3 < s.length(); ++i){
//                char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2), d = s.charAt(i + 3);
//                if(a == b && c == d) s.deleteCharAt(i + 2);
//            }
//            System.out.println(s);
//        }
//    }

    public static void check(String str) {

        if (str.length() < 3) {
            System.out.println(str);
            return;
        }

//        StringBuilder s = new StringBuilder(str);
//        for(int i = 0; i + 2 < s.length(); ++i){
//            char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2);
//            if(a == b && b == c) s.deleteCharAt(i--);
//        }
//        for(int i = 0; i + 3 < s.length(); ++i){
//            char a = s.charAt(i), b = s.charAt(i + 1), c = s.charAt(i + 2), d = s.charAt(i + 3);
//            if(a == b && c == d) s.deleteCharAt(i + 2);
//        }
//        System.out.println(s);
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (i < 2) {
                res.append(str.charAt(i));
                continue;
            }
            // 第一次检查拼写错误
            char c = str.charAt(i);
            char c3 = res.charAt(res.length() - 1);
            char c2 = res.charAt(res.length() - 2);

            if (c2 == c3 && c3 == c) {
                continue;
            }

            if (res.length() >= 3) {
                char c1 = res.charAt(res.length() - 3);
                if (c1 == c2 && c3 == c) {
                    continue;
                }
            }
            res.append(c);
        }
//
        System.out.println(res);
    }
}

package com.example.leetcode.huawei;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {

//    public static void main(String[] args) {
//        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
//        // please finish the function body here.
//        // please define the JAVA output here. For example: System.out.println(s.nextInt());
//        Scanner scan = new Scanner(System.in);
//        if (scan.hasNextLine()) {
//            String str = scan.nextLine();
//            String[] s1 = str.split(" ");
//            int i = 0;
//            double len = 0;
//            for (; i < s1.length; i++) {
//                len += s1[i].length();
//            }
//            double v = len / i;
//            double v1 = new BigDecimal(v).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//            System.out.println(v1);
//        }
//    }

    public static List<Character> yy = new ArrayList<>();
    public static List<Character> byy = new ArrayList<>();

    static {
        yy.add('a');
        yy.add('e');
        yy.add('i');
        yy.add('o');
        yy.add('u');
        byy.add('A');
        byy.add('E');
        byy.add('I');
        byy.add('O');
        byy.add('U');
    }

    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner scan = new Scanner(System.in);


        if (scan.hasNextLine()) {
            String str = scan.nextLine();
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                // 元音且小写就转换为大写 || 大写不是元音,就转为小写
                if ((yy.contains(c)) || (!byy.contains(c) && (c >=65 && c <=90))) {
                    c ^= 1 << 5;
                }
                stringBuilder.append(c);
            }
            System.out.println(stringBuilder);
        }

    }

}

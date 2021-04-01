package com.example.leetcode.hangdian;

import org.apache.logging.log4j.util.Strings;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:34 2020/4/17
 * @param:
 */
public class Main2030 {

//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        scanner.nextLine();
//
//        for (int i = 0; i < n; i++) {
//            String s = scanner.nextLine();
//            int count = 0;
//            byte[] bytes = s.getBytes();
//            /*C / C++ 中，char 类型占 1 个字节，Java 中char 类型占 2 个字节。
//            因为Java 中无论是汉字还是英文字母都是用 Unicode 编码来表示的，一个 Unicode 码是 16 位，每字节是 8 位，
//            所以一个 Unicode 码占两字节。但是英文字母比较特殊，源自于 8 位（1 字节）的 ASCII 码，
//            于是在 Unicode 码仅使用了低 8 位（1 字节）就
//            可以表示，高 8 位的话不使用也无所谓。所以，在这里不能使用 char 类型判断汉字机内码，需要使用 byte 类型。*/
//
//            for (int j = 0; j < bytes.length; j++) {
//                if (bytes[j] < 0) count++;
//            }
//            System.out.println(count / 2);
//        }
//    }

//    public static void main(String[] args) {
//        Scanner sn = new Scanner(System.in);
//        int n = Integer.parseInt(sn.nextLine());
//        int count;
//        while (n-- != 0) {
//            count = 0;
//            String a = sn.nextLine();
//            byte[] bys = a.getBytes();/*
//             * C / C++ 中，char 类型占 1 个字节，Java 中char 类型占 2 个字节。因为Java 中无论是汉字还是英文字母都是用 Unicode
//             * 编码来表示的，一个 Unicode 码是 16 位，每字节是 8 位，所以一个 Unicode 码占两字节。但是英文字母比较特殊，源自于 8 位（1
//             * 字节）的 ASCII 码，于是在 Unicode 码仅使用了低 8 位（1 字节）就/<br>可以表示，高 8 位的话不使用也无所谓。所以，在这里不能使用
//             * char 类型判断汉字机内码，需要使用 byte 类型。
//             */
//            int len = bys.length;
//            for (int i = 0; i < len; i++) {
//                if (bys[i] < 0)
//                    count++;
//            }
//            System.out.println(count / 2);
//        }
//        sn.close();
//    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        int count;
        while (n-- != 0) {
            count = 0;
            String a = scan.nextLine();
            byte[] bys = a.getBytes();
/*C / C++ 中，char 类型占 1 个字节，Java 中char 类型占 2 个字节。因为Java 中无论是汉字还是英文字母都是用 Unicode 编码来表示的，一个 Unicode 码是 16 位，每字节是 8 位，所以一个 Unicode 码占两字节。但是英文字母比较特殊，源自于 8 位（1 字节）的 ASCII 码，于是在 Unicode 码仅使用了低 8 位（1 字节）就/
可以表示，高 8 位的话不使用也无所谓。所以，在这里不能使用 char 类型判断汉字机内码，需要使用 byte 类型。*/
            int l = bys.length;
            for (int i = 0; i < l; i++) {
                if (bys[i] < 0)
                    count++;
            }
            System.out.println(count / 2);
        }

    }
}

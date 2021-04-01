package com.example.leetcode.hangdian;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:16 2020/4/18
 * @param:
 */

public class Main2054 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            String a1 = input.next();
            String b1 = input.next();
            a1 = ChuLi(a1);
            b1 = ChuLi(b1);
            //	System.out.println(a1+"####"+b1);
            BigDecimal a = new BigDecimal(a1);
            BigDecimal b = new BigDecimal(b1);

            if (a.equals(b))
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }

    private static String ChuLi(String a1) {
        boolean ok = false;
        a1 = a1.replace("+", "");//处理掉前边的“+”号
        if (a1.startsWith("-")) {//先暂时忽略“-”号
            a1 = a1.substring(1);
            ok = true;//记着标记有没有“-”号哦
        }
        if (a1.contains(".")) {//有小数点的情况
            //先去掉后边所有的0
            int num = 0;
            for (int i = a1.length() - 1; i >= 0; i--) {
                if (a1.charAt(i) != '0') {
                    num = i + 1;
                    break;
                }
            }
            a1 = a1.substring(0, num);//去掉后边多余的0
            //先去掉前边所有的0
            num = 0;
            for (int i = 0; i < a1.length(); i++) {
                if (a1.charAt(i) != '0') {
                    num = i;
                    break;
                }
            }
            a1 = a1.substring(num);//
            if (a1.startsWith("."))//如何开头为“.”，则补零
                a1 = "0" + a1;
            if (a1.endsWith(".")) {//如果末尾为“.”，则去点
                a1 = a1.substring(0, a1.length() - 1);
            }
        } else {//没有小数点的情况
            int num = 0;
            for (int i = 0; i < a1.length(); i++) {//只需要处理前边0
                if (a1.charAt(i) != '0') {
                    num = i;
                    break;
                }
            }
            a1 = a1.substring(num);
        }
        if (ok)
            a1 = "-" + a1;
        return a1;
    }

}

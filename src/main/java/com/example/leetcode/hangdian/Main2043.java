package com.example.leetcode.hangdian;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  14:02 2020/4/18
 * @param:
 */
public class Main2043 {

    /**
     * 正则       Pattern.compile("[A-Z]").matcher(s).find()
     * @param args
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        scan.nextLine();
        while (m-- > 0) {
            int count = 0;
            String s = scan.nextLine();
            if (Pattern.compile("[A-Z]").matcher(s).find()) {
                count++;
            }
            if (Pattern.compile("[a-z]").matcher(s).find()) {
                count++;
            }
            if (Pattern.compile("[0-9]").matcher(s).find()) {
                count++;
            }
            if (Pattern.compile("[~!@#$%^]").matcher(s).find()) {
                count++;
            }
            if(count>=3)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}

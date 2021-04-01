package com.example.leetcode.hangdian;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-17 14:12
 */
public class Main2026 {
    /**
     * 输入一个英文句子，将每个单词的第一个字母改成大写字母。
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.nextLine();
            String[] split = s.split(" ");
            for (int i = 0; i < split.length; i++) {
                char[] chars = split[i].toCharArray();
                chars[0] = Character.toUpperCase(chars[0]);
                System.out.print(chars[0]);
                for (int j = 1; j < chars.length; j++) {
                    System.out.print(chars[j]);
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void method2(String s) {
        //匹配一个单词边界，也就是指单词和空格间的位置。例如， 'er\b' 可以匹配"never" 中的 'er'，但不能匹配 "verb" 中的 'er'。
        //\B   匹配非单词边界。'er\B' 能匹配 "verb" 中的 'er'，但不能匹配 "never" 中的 'er'。
        Matcher m = Pattern.compile("\\b[a-z]").matcher(s);
        StringBuffer sb = new StringBuffer(s.length());
        while (m.find()) {
            m.appendReplacement(sb, m.group().toUpperCase());
        }
        m.appendTail(sb);
        System.out.println(sb.toString());
    }
}

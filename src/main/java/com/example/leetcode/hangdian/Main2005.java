package com.example.leetcode.hangdian;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  18:56 2020/4/15
 * @param:
 */
public class Main2005 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String date = scanner.nextLine();
            String[] split = date.split("/");
            LocalDate localDate = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            int dayOfYear = localDate.getDayOfYear();
            System.out.println(dayOfYear);
        }
    }
}

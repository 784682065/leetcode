package com.example.leetcode.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    static String res;

    public static void main(String[] args) {
        res = "invalid";
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            nums.add(scanner.nextInt());
        }
        boolean[] valid = new boolean[6];
        String s = validTime(nums, valid, new StringBuilder());
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < 6 ; i++) {

            r.append(s.charAt(i));
            if (i % 2 != 0 && i != 5){
                r.append(":");
            }

        }
        System.out.println(r);
    }


    public static String validTime(List<Integer> nums, boolean[] valid, StringBuilder path) {

        if (path.length() == 6) {
            // 验证对比 res, 最大的话, 就是他
            res = compareTime(res, path);
        }
        for (int i = 0; i < nums.size(); i++) {
            Integer integer = nums.get(i);
            if ((path.length() == 0 && integer > 2) ||
                    (path.length() == 1 && integer > 3) ||
                    (path.length() ==  2 && integer >= 6) ||
                    (path.length() ==  4 && integer >= 6) ) {
                continue;
            }

            if (!valid[i])
                path.append(integer);
            else
                continue;

            valid[i] = true;
            validTime(nums, valid, path);
            path.delete(path.length() - 1, path.length());
            valid[i] = false;
        }

        return res;
    }

    private static String compareTime(String res, StringBuilder path) {
        if (res.equals("invalid")) {
            return path.toString();
        }
        for (int i = 0; i < 6; i++) {
            if (path.charAt(i) > res.charAt(i)) {
                return path.toString();
            }
            if (res.charAt(i) > path.charAt(i)) {
                return res;
            }
        }

        return res;
    }

}

package com.example.leetcode.hangdian;

import java.util.*;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:59 2020/4/17
 * @param:
 */
public class Main2031 {

    static HashMap<Integer, String> hashMap = new HashMap<>();

    static {
        hashMap.put(10, "A");
        hashMap.put(11, "B");
        hashMap.put(12, "C");
        hashMap.put(13, "D");
        hashMap.put(14, "E");
        hashMap.put(15, "F");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int xr = scanner.nextInt();
            int r = scanner.nextInt();

            StringBuffer stringBuffer = new StringBuffer();
            int x = Math.abs(xr);
            if (x == 0) {
                System.out.println(0);
                continue;
            }

            while (x != 0) {
                int i = x % r;
                // 别忘记等于号
                if (i >= 10) {
                    stringBuffer.append(hashMap.get(i));
                } else {
                    stringBuffer.append(i);
                }
                x = x / r;
            }
            if (xr < 0) {
                System.out.print("-");
            }
            System.out.println(stringBuffer.reverse());
        }
    }
}

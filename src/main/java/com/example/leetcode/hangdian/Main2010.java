package com.example.leetcode.hangdian;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  20:35 2020/4/15
 * @param:
 */
public class Main2010 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            ArrayList<Integer> arrayList = new ArrayList();
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            for (int i = m; i <= n; i++) {
                int x = i / 100;
                int y = (i / 10) % 10;
                int z = i % 10;
                if(x*x*x + y*y*y + z*z*z == i){
                    arrayList.add(i);
                }
            }
            if (arrayList.size() > 0) {
                arrayList.forEach(a -> System.out.print(a +" " ));
                System.out.print("\n");
            }else {
                System.out.println("no");
            }

        }

    }

}

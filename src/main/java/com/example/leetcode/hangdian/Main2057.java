package com.example.leetcode.hangdian;

import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  21:09 2020/4/18
 * @param:
 */
public class Main2057 {



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            //next 与 next line 的区别就是 前者 以空格与换行为标记 后者以换行为标记
            String s1 = scanner.next();
            String s2 = scanner.next();

            long l1 = Long.parseLong(s1,16);
            long l2 = Long.parseLong(s2,16);

            long sum = l1 + l2;
            if(sum<0){
                //若sum 为负数， 则先转为正数， 不然会出现FFFFFF 开头情况，不是答案要求的标准输出
                System.out.println("-" + Long.toHexString((-1)*sum).toUpperCase());
            }else{
                System.out.println(Long.toHexString(sum).toUpperCase());
            }


        }
    }

}

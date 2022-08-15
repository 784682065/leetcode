package com.example.leetcode.dajiang;

import java.util.*;

public class Main1 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int res;
//
//        int hours_size = 0;
//        hours_size = in.nextInt();
//        int[] hours = new int[hours_size];
//        for (int hours_i = 0; hours_i < hours_size; hours_i++) {
//            hours[hours_i] = in.nextInt();
//        }
//
//        if (in.hasNextLine()) {
//            in.nextLine();
//        }
//
//        res = longestWPI(hours);
//        System.out.println(String.valueOf(res));
//    }

    public static void main(String[] args) {

        Main1 main1 = new Main1();
        int[] hours = {9,9,6,0,6,6,9};
        longestWPI(hours);
    }
    public static int longestWPI(int[] hours) {
        if (hours.length == 0) {
            return 0;
        }

        int[] tiredArr = new int[hours.length+1];
        // 疲劳天数
        tiredArr[0] = hours[0] <= 8 ? -1 : 1;
        for (int i = 0; i < hours.length; i++) {
            tiredArr[i+1] = tiredArr[i] + (hours[i] <= 8 ? -1 : 1);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tiredArr.length; i++) {
            if ( stack.isEmpty()  ){
                stack.push(i);
                continue;
            }
            if (tiredArr[stack.peek()] > tiredArr[i]){
                stack.push(i);
            }
        }

        int res = 0;
        for (int i = hours.length; i >=0 ; i--) {
            while (!stack.isEmpty() && tiredArr[stack.peek()] < tiredArr[i]){
                res = Math.max(res,i - stack.pop());
            }
        }
        return res;
    }


    public static int longestWPI2(int[] hours) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        for(int i = 0; i < hours.length; i++){
            int temp = hours[i] > 8 ? 1 : -1;
            sum += temp;
            if(sum > 0)
                res = i + 1;
            else {
                if(!sumToIndex.containsKey(sum))
                    sumToIndex.put(sum, i);
                if(sumToIndex.containsKey(sum - 1))
                    res = Math.max(res, i - sumToIndex.get(sum - 1));
            }
        }
        return res;
    }
}

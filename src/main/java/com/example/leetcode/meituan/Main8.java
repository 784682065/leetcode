package com.example.leetcode.meituan;

import java.util.*;

public class Main8 {

//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        String s = scanner.nextLine();
//        int n = Integer.parseInt(s);
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(scanner.nextInt());
//        }
//
//        int ans = 0;
//        list.sort(Comparator.naturalOrder());
//
//        for (int i = 0; i < list.size()- 2; i++) {
//            int ai = list.get(i);
//            for (int j = i+1; j < list.size() - 1; j++) {
//                int aj = list.get(j);
//                for (int k = j+1; k < list.size() ; k++) {
//                    int ak = list.get(k);
//                    if (ai - aj == (2*aj - ak))
//                        ++ans;
//                }
//            }
//        }
//        System.out.println(ans);
//    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = in.nextInt();
        }
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        left.put(nums[0],1);

        for(int i = 2; i < n; i++){
            right.put(nums[i], right.getOrDefault(nums[i],0)+1);
        }


        long ans= 0;
        // 用map 统计一下, 时间复杂度就变n^2 了
        for(int mid = 1; mid < n-1; mid++){
            for (Map.Entry<Integer,Integer> l: left.entrySet()){
                ans += (long) l.getValue() * ( right.getOrDefault(nums[mid] * 3-l.getKey(),0));
            }

            left.put(nums[mid],left.getOrDefault(nums[mid],0)+1);
            right.put(nums[mid+1],right.get(nums[mid+1])-1);
        }
        System.out.println(ans);


    }


}

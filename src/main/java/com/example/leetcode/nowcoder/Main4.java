package com.example.leetcode.nowcoder;

import java.util.*;

//public class Main4 {
//
//    static boolean flag;
//
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int[] nums = new int[10];
//        for (int i = 0; i < 13; i++) {
//            nums[cin.nextInt()]++;
//        }
//
//        for (int i = 1; i <= 9; i++) {
//            if (nums[i] <= 3) {
//                int[] card = Arrays.copyOf(nums, nums.length);
//                card[i]++;
//                flag = false;
//                if (isHu(card, 1, 14)) {
//                    System.out.print(i + " ");
//                }
//            }
//        }
//    }
//
//    public static boolean isHu(int[] card, int start, int total) {
//        if (total == 0) {
//            flag = true;
//            return flag;
//        }
//        // 把该牌当作雀头 , 有了雀头之后total % 3 一定等于 0 ,因为少了两张牌,后面的都是三张三张少的
//        if (card[start] >= 2 && total % 3 != 0) {
//            card[start] -= 2;
//            if (card[start] == 0 && start + 1 <= 9) {
//                flag = isHu(card, start + 1, total - 2);
//            } else {
//                flag = isHu(card, start, total - 2);
//            }
//            // 回溯，去判断下一种情况
//            card[start] += 2;
//        }
//        // 把该牌当作顺子
//        if (card[start] >= 3) {
//            card[start] -= 3;
//            if (card[start] == 0 && start + 1 <= 9) {
//                flag = isHu(card, start + 1, total - 3);
//            } else {
//                flag = isHu(card, start, total - 3);
//            }
//            // 回溯，去判断下一种情况
//            card[start] += 3;
//        }
//        // 把该牌当作刻子
//        if (start + 2 <= 9 && card[start] > 0 && card[start + 1] > 0 && card[start + 2] > 0) {
//            card[start]--;
//            card[start + 1]--;
//            card[start + 2]--;
//            if (card[start] == 0) {
//                flag = isHu(card, start + 1, total - 3);
//            } else {
//                flag = isHu(card, start, total - 3);
//            }
//            // 回溯，去判断下一种情况
//            card[start]++;
//            card[start + 1]++;
//            card[start + 2]++;
//        }
//        // 这种牌没了，去判断下一种牌
//        if (card[start] == 0) {
//            flag = isHu(card, start + 1, total);
//        }
//        return flag;
//    }
//
//
//}


public class Main4 {
    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){

            String[] str=sc.nextLine().split(" ");
            int[] nums=new int[13];
            for (int i = 0; i <13 ; i++) {
                nums[i]=Integer.parseInt(str[i]);
            }
            int[] backet=new int[9];
            int[] helper=new int[9];

            for (int i = 0; i <13 ; i++) {
                int num=nums[i];
                backet[num-1]++;
            }


            List<Integer> res= new ArrayList<>();

            for (int i = 0; i <9 ; i++) {
                if(backet[i]<4){
                    int num=i+1;
                    System.arraycopy(backet,0,helper,0,9);
                    //抽一张牌
                    helper[i]++;
                    if(canHu(helper,14,false))
                        res.add(num);
                }
            }

            if(res.isEmpty()){
                System.out.println(0);
            }else{
                StringBuilder sb=new StringBuilder();
                sb.append(res.get(0));
                for (int i =1; i <res.size() ; i++) {
                    sb.append(" ");
                    sb.append(res.get(i));
                }
                System.out.println(sb);
            }
        }
    }


    private static boolean canHu(int[] helper,int total,boolean hasHead){
        //能不能胡的最核心的指标是，是否可以将所14张牌匹配的剩下0张，并不关注谁做雀头，谁配顺子，谁配刻子
        //至于具体如何匹配，需要尝试，需要回溯，需要按照2条规则去匹配
        if(total==0) return true;

        //因为要胡，必须有雀头，刻子或者顺子可有可无，所以确定雀头,只有确定了雀头，才能继续匹配
        if(!hasHead){
            for (int i = 0; i <9 ; i++) {
                if(helper[i]>=2){ //大于等于2才可以做雀头
                    helper[i]-=2;
                    if(canHu(helper,total-2,true))
                        return true;
                    helper[i]+=2;
                }
            }
            //如果没有雀头，直接返回false;
            return false;
        }else{
            //已经与有雀头了，因此按照配顺子和配刻子的规则配
            for (int i = 0; i <9 ; i++) {
                if(helper[i]>0){

                    if(helper[i]>=3){  //够三个时考虑配刻子
                        helper[i]-=3;
                        if(canHu(helper,total-3,hasHead)) return true;
                        helper[i]+=3;
                    }

                    // 以helper[i]开头配顺子，此处只关心以谁开头，因此所有可能的牌都要遍历,只用关心谁开头
                    if(i+2<9 && helper[i+1]>0 && helper[i+2]>0){
                        helper[i]--;
                        helper[i+1]--;
                        helper[i+2]--;
                        if(canHu(helper,total-3,hasHead)) return true;
                        helper[i]++;
                        helper[i+1]++;
                        helper[i+2]++;
                    }
                }
            }
        }
        return false;
    }
}

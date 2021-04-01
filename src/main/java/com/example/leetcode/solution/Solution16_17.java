package com.example.leetcode.solution;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:58 2020/5/2
 * @param:
 */
public class Solution16_17 {


    public static void main(String[] args) {

        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = maxSubArray(nums);
        System.out.println(i);
    }



    public static int maxSubArray(int[] nums) {
        return maxSub(nums,0,nums.length-1);
    }

    public static int maxSub(int[]nums,int left,int right )
    {
        //一定将左右边界最大初始化为MIN_VALUE，初始化为0的时候全为负数过不去
        int maxleftbordersum =  Integer.MIN_VALUE,maxrightbordersum = Integer.MIN_VALUE;
        int leftmaxsum = Integer.MIN_VALUE,rightmaxsum = Integer.MIN_VALUE;
        int leftbordersum = 0,rightbordersum = 0;

        int mid = left+(right-left)/2;
        if(left==right)
        {
            return nums[left];
        }
        leftmaxsum = maxSub(nums,left,mid);		//计算得到左子数组的最大值
        rightmaxsum= maxSub(nums,mid+1,right);	//计算得到右子数组的最大值

        for(int i = mid;i >= left ;i--)		//一定要从中间向两端加！！！
        {
            leftbordersum += nums[i];
            if(leftbordersum > maxleftbordersum)
                maxleftbordersum = leftbordersum;
        }

        for(int i = mid+1 ;i <= right;i++)
        {
            rightbordersum += nums[i];
            if(rightbordersum > maxrightbordersum)
                maxrightbordersum = rightbordersum;
        }
        //返回三者最大值
        return Integer.max(leftmaxsum,Integer.max(rightmaxsum,maxleftbordersum+maxrightbordersum));
    }




    public static int maxSubArray2(int[] nums) {
        int b = nums[0];
        //开始的财产综合
        int sum = b;
        //主要是自己加起来是正的 那就继续掠夺
        for (int i = 1; i < nums.length; i++) {
            //见人就抢, 如果自己值为负数,就丢了自己的再抢 (为了连续子序列)
            if (b > 0) {
                b += nums[i];
            } else {
                b = nums[i];
            }

            if (b > sum) {
                sum = b;
            }
        }


        return sum;
    }


    public static int maxSubArray3(int[] nums) {

        int[] dp = new int[nums.length];

        int maxV = Integer.MIN_VALUE;


        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], dp[i]);
            maxV = Math.max(maxV, dp[i]);

        }

        return maxV;
    }


//    public static int maxSubArray(int[] nums) {
//
//        int maxV = Integer.MIN_VALUE;
//        int start = 0;
//        int end = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i; j < nums.length; j++) {
//                int sum = 0;
//                for (int k = i; k <= j; k++) {
//                    sum += nums[k];
//                    if (sum > maxV) {
//                        start = i;
//                        end = j;
//                        maxV =sum;
//                    }
//                }
//
//            }
//        }
//
//
//        return maxV;
//    }
}

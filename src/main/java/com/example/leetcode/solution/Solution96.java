package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-26 14:41
 */
public class Solution96 {


    /**
     * 结题思路：假设n个节点存在二叉排序树的个数是G(n)，1为根节点，2为根节点，...，n为根节点，
     * 当1为根节点时，其左子树节点个数为0，右子树节点个数为n-1，同理当2为根节点时，
     * 其左子树节点个数为1，右子树节点为n-2，所以可得G(n) = G(0)*G(n-1)+G(1)*(n-2)+...+G(n-1)*G(0)
     * <p>
     * 卡特兰数
     * G(n)=
     * i= 1
     * ∑  F(i,n)
     * n
     * ​
     * F(i,n) = G(i)*G(n-i)
     */
    public int numTrees(int n) {

        int[] G = new int[n + 1];

        //初始化
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}

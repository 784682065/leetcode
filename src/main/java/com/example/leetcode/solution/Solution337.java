package com.example.leetcode.solution;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-26 9:47
 */
public class Solution337 {

    //不能再方法外定义, 不然就是
    public int rob(TreeNode root) {

        if (root == null) return 0;
        int val1 = root.val;
        //  4 个孙子偷的钱 + 爷爷的钱 VS 两个儿子偷的钱 哪个组合钱多，就当做当前节点能偷的最大钱数。这就是动态规划里面的最优子结构
        if (root.left != null) { //节点的左子不为空,贼偷窃其节点的两个孙子节点
            val1 += rob(root.left.right) + rob(root.left.left);
        }
        if (root.right != null) { //节点的右子不为空,贼偷窃其节点的两个孙子节点
            val1 += rob(root.right.right) + rob(root.right.left);
        }
        int val2 = 0;
        val2 += rob(root.right) + rob(root.left);

        return Math.max(
                val1,
                val2
        );
    }
    

}

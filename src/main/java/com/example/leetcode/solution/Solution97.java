package com.example.leetcode.solution;

public class Solution97 {


    /**
     * 给定三个字符串 s1、s2、s3，请你帮忙验证s3是否是由s1和s2 交错 组成的。
     * <p>
     * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
     * <p>
     * s = s1 + s2 + ... + sn
     * t = t1 + t2 + ... + tm
     * |n - m| <= 1
     * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interleaving-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isInterleave(String s1, String s2, String s3) {

        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t)
            return false;

        /**
         *  1.  主要是看  s3的 第 i + j 的位置能不能由 s1的前i 个 和s2 的前j个组成
         *  2.  记 s3 的前i+j个 为 f[i][j]
         *  3.  记 f[i][j] 状态来源为
         *      3.1  f[i-1][j] &&  s1(i) == s3(i+j)
         *      或者
         *      3.2  f[i][j-1] &&  s2(j) == s3(i+j)
         */
        boolean[][] flag = new boolean[n + 1][m + 1];
        flag[0][0] = true;
        // 注意是小于等于
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // s3 的位置
                int pos = i + j -1;

                // 当i > 0 才能进入 f[i-1][j] ,表示s3 中至少有一个s1 的元素, 这样才能从他上一个状态得来
                if (i > 0){
                    flag[i][j] = flag[i-1][j] &&  s1.indexOf(i) == s3.indexOf(pos);
                }
                if (j > 0) {

                    /**
                     *  如果前一步i>0时已算出f[i][j]为true，则下面的||会短路，f[i][j]直接就是true了
                     *  这里多一个flag[i][j] 是因为 在s2 拿出j 这个值,可以拿也可以不拿
                     *  比如:
                     *      s1 aaa s2 bb  s3 aaabb  则 计算 f [2][1]可以s1拿出前面两个,而j 就不拿
                     */

                    flag[i][j] =  flag[i][j] ||  flag[i][j-1] &&  s2.indexOf(j) == s3.indexOf(pos);
                }
            }
        }
        return false;
    }


    public boolean isInterleaveRollArr(String s1, String s2, String s3) {

        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t)
            return false;

        //因为这里数组 f 的第 i 行只和第 i−1 行相关
        boolean[] flag = new boolean[m +1];
        flag[0] = true ;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                // s3 的位置
                int pos = i + j -1;

                if (i > 0){
                    flag[j] = flag[j] ||  flag[j-1] &&  s1.indexOf(i) == s3.indexOf(pos);
                }
                if (j > 0) {
                    flag[j] =  flag[j] ||  flag[j-1] &&  s2.indexOf(j) == s3.indexOf(pos);
                }
            }
        }

        return flag[m];
    }
}

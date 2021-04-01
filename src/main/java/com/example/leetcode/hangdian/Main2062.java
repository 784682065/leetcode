package com.example.leetcode.hangdian;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:11 2020/4/19
 * @param:
 */
public class Main2062 {


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long m = sc.nextLong();
            List<Integer> list = new LinkedList();  //初始集
            List<Integer> list1 = new ArrayList(); //结果集
            long num[] = new long[21];
            num[1] = 1;
            num[2] = 2;
            for (int i = 3; i < n + 1; i++) {    //每一组子集的个数
                num[i] = num[i - 1] * (i - 1) + 1;
            }
            list.add(0);
            for (int i = 1; i <= n; i++) {
                list.add(i);
            }
            for (int i = n; i > 0; i--) {  // 拿出list 中开头数字
                if (m % num[i] == 0) {    //取余为0 则表示开头数字索引位置为 (m / num[i])
                    list1.add(list.get((int) (m / num[i])));
                    list.remove(list.get((int) (m / num[i])));
                    m = num[i] - 1;
                } else {
                    list1.add(list.get((int) (m / num[i]) + 1));
                    list.remove(list.get((int) (m / num[i]) + 1));
                    m = m % num[i] - 1;
                    if (m == 0) break;
                }
            }
            for (int i = 0; i < list1.size(); i++) {
                if (i == 0) System.out.print(list1.get(i));
                else System.out.print(" " + list1.get(i));
            }
            System.out.println();

        }
    }


    /**
     * 一开始想直接用递归做，因为以前做过采用递归求全排列的问题，但是这样会走进一个误区，这个题目要求按字典序排，所以不能按照全排列的思想去解决。
     * 字典序这个要求比较有意思，从字典序中可以找到一些规律，用这些规律来解决掉这个问题。
     * <p>
     * 假设拿 n=3 m=10来说
     * 它的子集按照字典序排列会有如下顺序：
     * {1}
     * {1,2}
     * {1,2,3}
     * {1,3}
     * {1,3,2}
     * <p>
     * {2}
     * {2,1}
     * {2,1,3}
     * {2,3}
     * {2,3,1}
     * <p>
     * {3}
     * {3,1}
     * {3,1,2}
     * {3,2}
     * {3,2,1}
     * <p>
     * 从子集顺序上可以发现它们能够分成3组，每一组都有一个开头数字，去掉开头数字就是n=2时的情况数+1(空集)
     * <p>
     * 所以
     * 1.设f(n)是n个数字按照字典序所产生的子集个数，f(n) = n*( f(n-1) + 1 )，f(1)=1 
     * 这里需要强调按照字典序生成的子集，一个含有n个元素的集合真子集的个数是2^n-1，为什么按照字典序生成的子集却不符合这一规律？因为在按字典序生成时{1,2}和{2,1}认为是两个不同的集合，所以 f(n) >> 2^n-1。
     * <p>
     * 2.设g(n)是每一组子集的个数，g(n)=f(n)/n 
     * g(n-1)=f(n-1)/(n-1)，f(n) = n*( f(n-1) + 1 )，g(n)=(n-1)*g(n-1)+1 
     * <p>
     * <p>
     * 从上面子集顺序可以得到一个思路，我们可以先输出开头数字，然后把问题规模缩小到( n-1 , m-(t-1)*g(n)-1 )，不断缩小规模直至找到答案。
     * 怎么得到的 m-(t-1)*g(n)-1 ? t代表所求子集所在的组，每次问题规模缩小时，m都需要减去多余的子集，多余的子集数就是上面1~t-1组所含子集数和t组去掉开头数字后剩余的空集。
     * <p>
     * <p>
     * 主要步骤：
     * 1、求出所在组t
     * 2、输出所在组t的首元素s[t](同一组首元素相同)
     * 3、将该子集的下一个元素到最后一个的值+1,注意这个规律：在第i组，首元素为i，删除首元素后，在第i个子集后首元素均变大+1.
     * 4、缩减问题规模继续执行步骤1~3
     * <p>
     * ————————————————
     * 版权声明：本文为CSDN博主「Cloud97」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/qq_33266889/article/details/53468509
     *
     * @param args
     */
    //an = (n-1)*a(n-1) + 1
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] p = new int[21];
//        int[] s = new int[21];
//        p[0] = 0;
//        p[1] = 1;
//        for (int i = 2; i < 21; i++) {
//            p[i] = (i - 1) * p[i - 1] + 1;
//        }
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int m = scanner.nextInt();
//            for (int i = 0; i < 21; i++) {
//                s[i] = i;
//            }
//            while (n > 0 && m > 0) {
//                int t = m / p[n] + (m % p[n] > 0 ? 1 : 0);
//
//                if (t > 0) { //得到第m个子集在分组后的第t组
//                    System.out.print(s[t]);
//                    for (int i = t; i <= n; i++) {
//                        s[i] = s[i + 1];  // 当去掉开头数字后，大于开头数字的数+1
//                    }
//                    m -= ((t - 1) * p[n] + 1);          // 减去(t-1组总子集数+1）,m变为表示在剩余子集中位于第几个\
//                    if (m == 0){
//                        System.out.println();
//                    }else {
//                        System.out.print(" ");
//                    }
//                }
//                n--;   // 依次递减,直到执行上面的if代码或退出
//            }
//
//
//        }
//
//
//    }
//}
}
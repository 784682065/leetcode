package com.example.leetcode.solution;

/**
 * @author: hzp
 * @date: 2022/5/16
 * @description:
 */
public class Solution165 {

    /**
     * i < v1.length || i < v2.length; 可以使用这个条件
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion(String version1, String version2) {

        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");

        // 每行去除前导0
        int len = Math.min(split1.length, split2.length);

        for (int i = 0; i < len; i++) {
            Integer i1 = Integer.valueOf(split1[i]);
            Integer i2 = Integer.valueOf(split2[i]);

            if (i1.equals(i2)) {
                continue;
            }
            if (i1 > i2)
                return 1;
            else
                return -1;
        }

        // 到了这里说明

        if (split1.length > len) {
            for (int i = len; i < split1.length; i++) {
                int i1 = Integer.parseInt(split1[i]);
                if (i1 != 0) {
                    return 1;
                }
            }
        }

        if (split2.length > len) {
            for (int i = len; i < split2.length; i++) {
                int i1 = Integer.parseInt(split2[i]);
                if (i1 != 0) {
                    return -1;
                }
            }
        }


        return 0;
    }


    /**
     * 方法一需要存储分割后的修订号，为了优化空间复杂度，我们可以在分割版本号的同时解析出修订号进行比较
     * 一边分割一边比较.
     * @param version1
     * @param version2
     * @return
     */
    public int compareVersion2(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        Solution165 solution165 = new Solution165();

        String version1 = "0.1", version2 = "1.1";

        int i = solution165.compareVersion(version1, version2);
        System.out.println(i);
    }
}

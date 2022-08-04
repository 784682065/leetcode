package com.example.leetcode.codetop;


public class Solution165 {
    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            int a = (i >= v1.length ? 0 : Integer.parseInt(v1[i]));
            int b = (i >= v2.length ? 0 : Integer.parseInt(v2[i]));
            if (a > b) {
                return 1;
            }
            if (a < b) {
                return -1;
            }
            i++;
        }
        return 0;
    }

    public static void main(String[] args) {

        String version1 = "1.01", version2 = "1.001";
        Solution165 solution165 = new Solution165();
        System.out.println(solution165.compareVersion(version1, version2));

    }


}

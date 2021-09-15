package com.example.leetcode.solution;

public class Solution38 {

    static String[] a = new String[30];

    static {
        a[0] = "1";
        a[1] = "11";
        for (int i = 2; i < 30; i++) {

            // 1. 计算出几个一样的数字.
            String needCount = a[i - 1];
            StringBuilder res = new StringBuilder();
            int count = 0;
            int value = -1;
            for (int j = 0; j < needCount.length(); j++) {
                if (value == -1) {
                    value = needCount.charAt(j) - 48;
                    count++;
                    continue;
                }

                if (value == (needCount.charAt(j) - 48)) {
                    count++;
                } else {
                    res.append(count).append(value);
                    count = 1;
                    value = needCount.charAt(j) - 48;
                }
            }
            res.append(count).append(value);
            a[i] = res.toString();
        }
    }


    public String countAndSay(int n) {
        return a[n - 1];
    }

    public String diguiCountAndSay(int n) {
        if (n == 1) return "1";
        else {
            String lastStr = diguiCountAndSay(n - 1); // 1 2 1 1
            StringBuilder ans = new StringBuilder();
            int i = 0, j = 1, len = lastStr.length();
            while (j < len) {
                if (lastStr.charAt(i) != lastStr.charAt(j)) {
                    ans.append(j - i).append(lastStr.charAt(i));
                    i = j;
                }
                j++;
            }
            ans.append(j - i).append(lastStr.charAt(i));
            return ans.toString();
        }
    }


    public static void main(String[] args) {

        char a = '1';
        StringBuffer s = new StringBuffer();
        s.append(a);
        System.out.println(s.toString());



    }
}

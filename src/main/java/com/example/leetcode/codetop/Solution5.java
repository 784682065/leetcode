package com.example.leetcode.codetop;

public class Solution5 {


    public String longestPalindrome(String s) {
        if (s.length() == 1 || isPalindrome(s))
            return s;

        int[] max = {0, 1};
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                if ((j - i) < (max[1] - max[0])) {
                    break;
                }

                String substring = s.substring(i, j);
                boolean palindrome = isPalindrome(substring);
                if (palindrome) {
                    if ((j - i) > (max[1] - max[0])) {
                        max[0] = i;
                        max[1] = j;
                        break;
                    }
                }
            }
        }
        return s.substring(max[0], max[1]);
    }

    public boolean isPalindrome(String s) {

        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            char head = s.charAt(i);
            char tail = s.charAt(length - i - 1);
            if (head != tail) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindromeDP(String s) {
        if (s.length() == 1 || isPalindrome(s))
            return s;

        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // 由 L 和 i 可以确定右边界，即 j - i + 1 = L 得
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


    /**
     * 由于存在奇数的字符串和偶数的字符串，所以我们需要从一个字符开始扩展，
     * 或者从两个字符之间开始扩展，所以总共有 n+n-1 个中心。
     * @param s
     * @return
     */
    public String longestPalindromeEAC(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return right - left - 1;
    }


    public static void main(String[] args) {
        Solution5 solution5 = new Solution5();
        String s = "babad";
        String s1 = solution5.longestPalindromeEAC(s);
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s.length());

//        System.out.println(s.length());
//        System.out.println(s.substring(0,s.length()).length());
    }

}

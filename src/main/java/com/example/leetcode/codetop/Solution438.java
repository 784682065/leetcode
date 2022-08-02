package com.example.leetcode.codetop;

import javax.print.DocFlavor;
import java.util.*;

public class Solution438 {

    /**
     * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
     * 异位词, 这种固定长度的都是定长窗口运动,
     * Solution 76 这种都是找覆盖子串的都是不定长窗口移动.
     */
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {
            return res;
        }

        int left = 0, right = left + p.length() ;
        HashMap<Character, Integer> cntp = new HashMap<>();
        HashMap<Character, Integer> cnts = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char charAt = p.charAt(i);
            cntp.put(charAt, cntp.getOrDefault(charAt, 0) + 1);
            char charAt1 = s.charAt(i);
            cnts.put(charAt1, cnts.getOrDefault(charAt1, 0) + 1);
        }


        while (right < s.length()) {
            if (check(cntp, cnts)) {
                res.add(left);
            }
            char leftChar = s.charAt(left);
            int leftCount = cnts.get(leftChar) - 1;
            if (leftCount == 0) {
                cnts.remove(leftChar);
            } else {
                cnts.put(leftChar, leftCount);
            }
            left++;
            char rightChar = s.charAt(right);
            cnts.put(rightChar, cnts.getOrDefault(rightChar, 0) + 1);
            right++;
        }
        if (check(cntp, cnts)) {
            res.add(left);
        }
        return res;
    }

    public boolean check(HashMap<Character, Integer> cntp, HashMap<Character, Integer> cnts) {

        for (Map.Entry<Character, Integer> characterIntegerEntry : cntp.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();
            if (cnts.get(key) == null || cnts.get(key) != value) {
                return false;
            }
        }
        return true;
    }



    public List<Integer> findAnagramsOffical(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] count = new int[26];
        // 单纯字母用数组来记录的话更简单一点
        for (int i = 0; i < pLen; ++i) {
            ++count[s.charAt(i) - 'a'];
            --count[p.charAt(i) - 'a'];
        }
        int differ = 0;
        for (int j = 0; j < 26; ++j) {
            if (count[j] != 0) {
                ++differ;
            }
        }

        if (differ == 0) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            // left 出库,  原先是1的话,说明p字符串这个字母多一个, 出了就少一个 , 0的话说明原先一样,现在出了就要多一个不一样的
            if (count[s.charAt(i) - 'a'] == 1) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i) - 'a'] == 0) {  // 窗口中字母 s[i] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            --count[s.charAt(i) - 'a'];

            //right 入库
            if (count[s.charAt(i + pLen) - 'a'] == -1) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从不同变得相同
                --differ;
            } else if (count[s.charAt(i + pLen) - 'a'] == 0) {  // 窗口中字母 s[i+pLen] 的数量与字符串 p 中的数量从相同变得不同
                ++differ;
            }
            ++count[s.charAt(i + pLen) - 'a'];

            if (differ == 0) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
       String s = "aaaaaaaa", p = "aaaa";
        Solution438 solution438 = new Solution438();
        List<Integer> anagrams = solution438.findAnagrams(s, p);
        System.out.println(anagrams);

    }

}

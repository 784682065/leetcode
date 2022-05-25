package com.example.leetcode.codetop;

import java.util.HashMap;

/**
 * @author: hzp
 * @date: 2022/5/22
 * @description:
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {

        // 双指针
        int length = s.length();
        if (length <= 1) {
            return length;
        }

        int low = 0;
        int max = 0;
        int fast;

        for (fast = 1; fast < length; fast++) {
            char charAt = s.charAt(fast);

            String substring = s.substring(low, fast);
            int indexOf = substring.indexOf(charAt);
            if (indexOf != -1) {
                // 记录下max
                //要移动low指针
                low = indexOf + 1 + low;
            }
            // 不然就继续
            max = Math.max(max, (fast - low +1));
        }
        return max;
    }

    /**
     * 使用hashMap记录位置
     * 后一个字母会顶替掉前一个相同字母的位置
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_1(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            // 记录i 到left 的距离,
            // left 会在之前被更新,而不是像我想的统计完再去更新left
            // 这就是为什么 max 可以放在for循环里的原因,而不用再一次的使用if
            max = Math.max(max, i - left + 1);
        }
        return max;

    }


    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        String s = "pwwkew";
        int i = solution3.lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}

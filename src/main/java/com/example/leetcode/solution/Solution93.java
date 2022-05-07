package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: hzp
 * @date: 2022/5/7
 * @description:
 */
public class Solution93 {


    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        res = new ArrayList<>();
        int length = s.length();
        if (length < 4 || length > 12)
            return res;

        subIp(s, "", 0);

        return res;
    }


    public void subIp(String s, String ipString, int times) {
        if (times > 3)
            return;

        // 截取第一部分可以有的开头

        for (int i = 1; i < 4; i++) {
            StringBuilder ipStringBuilder = new StringBuilder(ipString);
            // 还需要加规则限制 , 不能0 开头
            if (i > s.length()) {
                break;
            }
            String ipD = s.substring(0, i);
            // 不能有前导0,且不能大于255
            if ((ipD.startsWith("0") && ipD.length() != 1) || Integer.parseInt(ipD) > 255)
                continue;

            String substring = s.substring(i);
            if (substring.length() > ((3 - times) * 3))
                continue;

            if (times == 0) {
                ipStringBuilder.append(ipD);
            } else {
                ipStringBuilder.append('.').append(ipD);
            }

            if (ipStringBuilder.toString().split("\\.").length == 4 && substring.length() == 0) {
                res.add(ipStringBuilder.toString());
                return;
            }

            subIp(substring, ipStringBuilder.toString(), times + 1);
        }

    }

    public static void main(String[] args) {
        Solution93 solution93 = new Solution93();
        String s = "101023";
        solution93.restoreIpAddresses(s);
    }


    static final int SEG_COUNT = 4;
    List<String> ans = new ArrayList<String>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses_official(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    public void dfs(String s, int segId, int segStart) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == SEG_COUNT) {
            if (segStart == s.length()) {
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < SEG_COUNT; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != SEG_COUNT - 1) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        // 如果还没有找到 4 段 IP 地址就已经遍历完了字符串，那么提前回溯
        if (segStart == s.length()) {
            return;
        }

        // 由于不能有前导零，如果当前数字为 0，那么这一段 IP 地址只能为 0
        if (s.charAt(segStart) == '0') {
            segments[segId] = 0;
            dfs(s, segId + 1, segStart + 1);
        }

        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int segEnd = segStart; segEnd < s.length(); ++segEnd) {
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if (addr > 0 && addr <= 0xFF) {
                segments[segId] = addr;
                dfs(s, segId + 1, segEnd + 1);
            } else {
                break;
            }
        }
    }

}

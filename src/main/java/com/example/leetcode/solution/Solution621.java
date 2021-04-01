package com.example.leetcode.solution;

import java.util.*;
import java.util.jar.JarEntry;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  11:34 2020/5/1
 * @param:
 */
public class Solution621 {

    public static void main(String[] args) {
        Solution621 solution621 = new Solution621();
        char[] task = {'A','A','A','B','B','B'};

        solution621.leastInterval(task,2);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) { //每次选n +1 个任务执行
                if (map[25] == 0)
                    break;
                //表示从最多的任务开始执行
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map); // 当map[25] == 0 时, 前面还有任务没消费, 需要在排序把最大的放到 25 位置
        }
        return time;
    }

}
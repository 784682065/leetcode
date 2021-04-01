package com.example.leetcode.solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:00 2020/5/1
 * @param:
 */
public class Solution649 {

    public static void main(String[] args) {
        Solution649 solution649 = new Solution649();
        String rd = solution649.predictPartyVictory("DR");
        System.out.println(rd);

    }

    public String predictPartyVictory(String senate) {
        Queue<Integer> queue = new LinkedList();
        int[] people = new int[]{0, 0};
        int[] bans = new int[]{0, 0};

        for (char person: senate.toCharArray()) {
            int x = person == 'R' ? 1 : 0;
            people[x]++;
            queue.add(x);
        }

        while (people[0] > 0 && people[1] > 0) {
            //队列保证第一个元素一定先实行禁令
            int x = queue.poll();
            if (bans[x] > 0) {
                bans[x]--;
                people[x]--;
            } else {
                bans[x^1]++;
                queue.add(x);
            }
        }

        return people[1] > 0 ? "Radiant" : "Dire";
    }

}

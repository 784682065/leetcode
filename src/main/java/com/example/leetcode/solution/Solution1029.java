package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  10:32 2020/5/1
 * @param:
 */
public class Solution1029 {

    public int twoCitySchedCost(int[][] costs) {

        int length = costs.length;
        //然后选择一半的人飞往A , 差价是PriceA - PriceB, 最小的一半即可
        List<Integer> spread = new ArrayList<>();
        int sum = 0;
        //先假装全部人飞往B市
        for (int i = 0; i < length; i++) {
            sum += costs[i][1];
            spread.add(costs[i][0] - costs[i][1]);
        }

        spread.sort(Integer::compareTo);
        for (int i = 0; i < length / 2; i++) {
            sum += spread.get(i);
        }

        return sum;
    }

}

package com.example.leetcode.specialtraining;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: huzp
 * @Description:
 * @Date: Created in  22:42 2020/5/14
 * @param:
 */
public class Solution1018 {

    public List<Boolean> prefixesDivBy5(int[] A) {

        /**
         * 可以每添加一位求一次余数，然后在余数的基础上继续求下一位，依次类推
         */
        ArrayList<Boolean> ans = new ArrayList();

        int state = 0;
        for (int i = 0; i < A.length; i++) {
            state = ((state << 1) + A[i]) % 5;
            if (state == 0) ans.add(Boolean.TRUE);
            else ans.add(Boolean.FALSE);
        }

        return ans;
    }
}

package com.example.leetcode.codetop;

public class Solution470 {


    public int rand10() {
        int first, second;
        while ((first = rand7()) > 6);
        while ((second = rand7()) > 5);
        return (first&1) == 1 ? second : 5+second;
    }

    private int rand7() {
        return 0;
    }
}

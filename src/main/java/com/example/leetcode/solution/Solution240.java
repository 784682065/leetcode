package com.example.leetcode.solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution240 {

    public boolean searchMatrix(int[][] matrix, int target) {

        // 每个序列二分
        for (int[] row : matrix) {
            if (binarySearch(row,target)) {
                return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[] row,int target) {
        int left = 0 , right = row.length-1;
        while (left <= right){
            int mid = left + (right- left)/2;
            if (row[mid] == target){
                return true;
            } else if (row[mid]  < target) {
                left  = mid +1;
            }else {
                right = mid -1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][] matrix = {{-5}};
        Solution240 solution240 = new Solution240();
        int target = 15;
        System.out.println(solution240.searchMatrix(matrix, target));


    }
}

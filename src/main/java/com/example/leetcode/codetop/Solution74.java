package com.example.leetcode.codetop;

/**
 * @author: huzepeng
 * @date: 2022/10/10
 * @desc:
 */
public class Solution74 {

    // 因为行列均有序,所以两次二分查找,一个找行一个找列, 行的话只需要找一个最接近小于等于target的就好
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }



    public static void main(String[] args) {
//        int[][] matrix  = {{1,3,5,7},{10,11,16,20}};
        int[][] matrix  = {{1}};
        Solution74 solution74 = new Solution74();
        System.out.println(solution74.searchMatrix(matrix, 1));

    }
}

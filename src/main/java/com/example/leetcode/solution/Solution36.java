package com.example.leetcode.solution;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution36 {




    /**
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     *
     * @param board 数独
     * @return 是否是个正确地数独
     */
    public boolean isValidSudoku(char[][] board) {

        int[][] rawArr = new int[9][9];
        int[][] columnArr = new int[9][9];
        int[][] blockArr = new int[9][9];


        char valChar;
        int val;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                valChar = board[i][j];

                if (valChar == '.'){
                    continue;
                }

                //char 转int, 0 是48 , 数组从0 开始
                val = valChar - 48 - 1 ;
                //对行的校验
                if (rawArr[i][val] == 0) {
                    //表示第i行 有val 这个值了
                    rawArr[i][val] = 1;
                } else {
                    System.out.println("行出现问题" + i +","+val);
                    return false;
                }

                // 对列的校验
                if (columnArr[val][j] == 0) {
                    //表示第j列 有val 这个值了
                    columnArr[val][j] = 1;
                } else {
                    System.out.println("列出现问题:"+val +","+j);
                    return false;
                }

                // 对块的校验
                int blockI = i / 3;
                int blockJ = j / 3;

                // 两个都小于3 是第一组
                int m =0;
                for (int k = blockI * 3; k < blockI * 3 +3; k++) {
                    for (int l = blockJ * 3; l < blockJ * 3 +3; l++) {

                        if (m == val){
                            if (blockArr[k][l] !=0){
                                return false;
                            } else {
                                blockArr[k][l] = 1;
                            }
                        }
                        m++;
                    }
                }
            }
        }
        return true;
    }


    public boolean isValidSudokuEasyVersion(char[][] board) {
        int [][]row  =new int[9][10];
        int [][]col  =new int[9][10];
        int [][]box  =new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j]=='.'){
                    continue;
                }
                int curNum = board[i][j]-'0';
                if (row[i][curNum]==1){
                    return false;
                }if (col[j][curNum]==1){
                    return false;
                }
                if (box[j/3 + (i/3) * 3][curNum]==1){
                    return false;
                }
                row[i][curNum]=1;
                col[j][curNum]=1;
                box[j/3 + (i/3) * 3][curNum]=1;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        char[][] boards = 
{{'.','.','.','.','.','.','.','.','2'},
{'.','5','9','.','2','.','.','.','.'},
{'.','.','.','.','.','.','8','7','.'},
{'.','.','.','.','.','3','5','.','.'},
{'.','9','.','.','7','.','.','.','.'},
{'.','8','.','.','.','.','1','6','.'},
{'.','.','1','9','8','.','.','.','.'},
{'.','.','.','.','9','.','.','8','.'},
{'.','.','.','3','.','6','.','.','.'}};


        boolean validSudoku = solution36.isValidSudoku(boards);
        System.out.println(validSudoku);


    }





}

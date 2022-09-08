package com.example.leetcode.codetop;

import com.sun.corba.se.impl.naming.namingutil.INSURLBase;

import java.util.*;
import java.util.stream.Collectors;

public class Solution297 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }

    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return rdeserialize(dataList);
    }

    public String rserialize(TreeNode root, String str) {
        if (root == null) {
            str += "None,";
        } else {
            str += str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }

    public TreeNode rdeserialize(List<String> dataList) {
        if (dataList.get(0).equals("None")) {
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(dataList.get(0)));
        dataList.remove(0);
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);

        return root;
    }

    public static void main(String[] args) {

        Solution297 solution297 = new Solution297();
        TreeNode deserialize = solution297.deserialize("1,2,3,None,None,4,5");
        System.out.println();

    }
}

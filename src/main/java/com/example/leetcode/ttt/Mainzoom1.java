package com.example.leetcode.ttt;

import java.util.*;
import java.util.stream.Collectors;

public class Mainzoom1 {


    public static class TreeNodeZoom {
        int id;
        Character color;
        TreeNodeZoom left;
        TreeNodeZoom right;

        public TreeNodeZoom(int id, char color) {
            this.id = id;
            this.color = color;
        }

        public TreeNodeZoom getRight() {
            return right;
        }

        public void setRight(TreeNodeZoom right) {
            this.right = right;
        }

        public TreeNodeZoom getLeft() {
            return left;
        }

        public void setLeft(TreeNodeZoom left) {
            this.left = left;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Character getColor() {
            return color;
        }

        public void setColor(Character color) {
            this.color = color;
        }
    }

    static  int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = Integer.parseInt(scanner.nextLine());
        TreeNodeZoom[] treeNodeZooms = new TreeNodeZoom[len];
        String colors = scanner.nextLine();
        for (int i = 0; i < len; i++) {
            treeNodeZooms[i] = new TreeNodeZoom(i + 1, colors.charAt(i));
        }

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len-1; i++) {
            String[] arr = scanner.nextLine().split(" ");
            List<Integer> collect = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
            list.add(collect);
        }


        boolean[] used = new boolean[len];
        Stack<Integer> rootIds = new Stack<>();
        rootIds.add(1);
        treeBin(list, treeNodeZooms, len, used, rootIds);
        TreeNodeZoom root = treeNodeZooms[0];
        res = 0;
        countRes(root,0,0);
        System.out.println(res);
    }

    private static void countRes(TreeNodeZoom root, int red, int bule) {
        if (root == null){
            return;
        }
        if (root.getColor() == 'R'){
            red ++;
        }else {
            bule++;
        }
        res += Math.abs(red-bule);
        countRes(root.left,red,bule);
        countRes(root.right,red,bule);
    }


    private static void treeBin(List<List<Integer>> list, TreeNodeZoom[] treeNodeZooms, int len, boolean[] used, Stack<Integer> rootIds) {
        if (rootIds.isEmpty()) {
            return;
        }

        int size = rootIds.size();
        for (int k = 0; k < size; k++) {
            Integer rootId = rootIds.pop();
            // 找到第一条边,1
            for (int i = 0; i < list.size(); i++) {
                List<Integer> treeEdge = list.get(i);
                if (!used[i] && treeEdge.contains(rootId)) {
                    used[i] = true;
                    TreeNodeZoom treeNodeZoom = treeNodeZooms[rootId - 1];
                    int treeId = -1;
                    for (int j = 0; j < 2; j++) {
                        if (treeEdge.get(j) != 1) {
                            treeId = treeEdge.get(j);
                            break;
                        }
                    }
                    if (treeNodeZoom.left == null) {
                        treeNodeZoom.left = treeNodeZooms[treeId - 1];
                    } else {
                        treeNodeZoom.right = treeNodeZooms[treeId - 1];
                    }
                    rootIds.add(treeId);
                }
            }
        }
        treeBin(list, treeNodeZooms, len, used, rootIds);
    }
}

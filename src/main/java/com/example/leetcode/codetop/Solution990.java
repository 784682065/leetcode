package com.example.leetcode.codetop;

import java.util.*;

public class Solution990 {

    public boolean equationsPossible(String[] equations) {


        Map<Character, Set<Character>> equalMap = new HashMap<>();
        Map<Character, Set<Character>> unEqualMap = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            char x = equation.charAt(0);
            char y = equation.charAt(3);

            Set<Character> orDefaultSelf = equalMap.getOrDefault(x, new HashSet<>());
            orDefaultSelf.add(x);
            equalMap.put(x, orDefaultSelf);

            Set<Character> orDefaultSelf2 = equalMap.getOrDefault(y, new HashSet<>());
            orDefaultSelf2.add(y);
            equalMap.put(y, orDefaultSelf2);
            if (equation.charAt(1) == '!') {
                // 不相等
                this.store(x,y,unEqualMap);
                this.store(y,x,unEqualMap);
            } else {
                // 如果相等
               this.store(x,y,equalMap);
               this.store(y,x,equalMap);
            }
        }
        for (Map.Entry<Character, Set<Character>> characterSetEntry : equalMap.entrySet()) {
            Character key = characterSetEntry.getKey();
            Set<Character> equalValueSet = characterSetEntry.getValue();
            Set<Character> unEqualValueSet = unEqualMap.getOrDefault(key, new HashSet<>());
            // 如果有交集则有问题
            HashSet<Character> resSet = new HashSet<>();
            resSet.addAll(equalValueSet);
            resSet.removeAll(unEqualValueSet);
            if (resSet.size() != equalValueSet.size()) {
                return false;
            }
        }
        return true;
    }

    public void store(Character x, Character y ,Map<Character,Set<Character>> map){
        Set<Character> orDefaulty = map.getOrDefault(x,new HashSet<>());
        orDefaulty.add(y);
        map.put(x, orDefaulty);
        for (Character character : orDefaulty) {
            Set<Character> orDefault1 = map.getOrDefault(character, new HashSet<>());
            orDefault1.add(x);
            map.put(character, orDefault1);
        }
    }


    // 分开处理把相等的,
    // 1- 都连接到一个子节点,
    // 2- 不相等的都拿来找祖宗判断
    public boolean equationsPossibleOF(String[] equations) {
        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }
        for (String str : equations) {
            if (str.charAt(1) == '=') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                union(parent, index1, index2);
            }
        }
        for (String str : equations) {
            if (str.charAt(1) == '!') {
                int index1 = str.charAt(0) - 'a';
                int index2 = str.charAt(3) - 'a';
                if (find(parent, index1) == find(parent, index2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        while (parent[index] != index) {
            // 爷爷节点赋值给父亲节点
            parent[index] = parent[parent[index]];
            // 父亲节点赋值 给子节点
            index = parent[index];
        }
        // 返回祖宗id
        return index;
    }


    public static void main(String[] args) {

        String[] eq = {"a==b", "b!=c", "c==a"};
        Solution990 solution990 = new Solution990();
        System.out.println(solution990.equationsPossibleOF(eq));


    }
}

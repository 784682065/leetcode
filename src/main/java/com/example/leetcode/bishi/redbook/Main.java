package com.example.leetcode.bishi.redbook;
import java.util.*;

// 73
public class Main {

    public static class Pair {
        private Integer key;
        private Integer value;
        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int id = scanner.nextInt();

        Pair[] list = new Pair[n];
        for (int i = 0; i < n; i++) {
            Integer number = i + 1;
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += scanner.nextInt();
            }
            Pair pair = new Pair(number, sum);
            list[i] = pair;
        }

        Arrays.sort(list, (o1, o2) -> {
            if (o1.value != o2.value){
                return o2.value - o1.value;
            }else {
                return o1.key - o2.key;
            }
        });

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (id == list[i].key){
                ans = i+1;
                break;
            }
        }
        System.out.println(ans);
    }
}
package com.example.leetcode.codetop;

import java.util.*;

public class Solution692 {
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, 1 + map.getOrDefault(word, 0));
        }

        // 堆排序, 构建大根堆
        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (o1, o2) -> Objects.equals(o1.getValue(), o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue());

        // 小根堆更省时间
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            queue.offer(stringIntegerEntry);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        List<String> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            ret.add(queue.poll().getKey());
        }
        Collections.reverse(ret);

        return ret;
    }

    public static void main(String[] args) {
        String[] s = {"the","day","is","sunny","the","the","the","sunny","is","is"};
        Solution692 solution692 = new Solution692();
        List<String> strings = solution692.topKFrequent(s, 4);
        System.out.println(strings);
    }
}

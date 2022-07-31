package com.example.leetcode.codetop;

import java.util.*;

class FreqStack {

    // hashmap 里放Stack ,很秀
    Map<Integer, Stack<Integer>> freqStkMap; // 充当栈
    Map<Integer, Integer> numFreqMap; // 充当计数器
    int maxFreq; // 记录当前最高频率的值

    public FreqStack() {
        freqStkMap = new HashMap<>(); // <K, V>: 每个频率 K 对应有一个栈 V，栈 V 中存放所有频率为 K 的数字
        numFreqMap = new HashMap<>(); // <K, V>: 数字 K 的出现频率为 V
        maxFreq = 0;
    }

    public void push(int val) {
        // 记录数字出现的频率, 并更新当前最高频率的值
        int currFreq = numFreqMap.getOrDefault(val, 0) + 1;
        numFreqMap.put(val, currFreq);
        if (currFreq > maxFreq) {
            maxFreq = currFreq;
        }
        // 按频率不同, 建立栈. 存入出现过该频率的数字
        freqStkMap.putIfAbsent(currFreq, new Stack<>());
        freqStkMap.get(currFreq).push(val);
    }

    public int pop() {
        // 找到并移除当前频率最高的数字
        int maxFreqNum = freqStkMap.get(maxFreq).pop();
        // 将该数字的频率减去 1
        numFreqMap.put(maxFreqNum, numFreqMap.get(maxFreqNum) - 1);
        // 如果当前最高频率的栈为空, 说明最高频率需要更新 (减去 1)
        if (freqStkMap.get(maxFreq).size() == 0) {
            maxFreq--;
        }
        return maxFreqNum;
    }

    public static void main(String[] args) {
        FreqStack freqStack  = new FreqStack();
        freqStack.push (5);//堆栈为 [5]
        freqStack.push (7);//堆栈是 [5,7]
        freqStack.push (5);//堆栈是 [5,7,5]
        freqStack.push (7);//堆栈是 [5,7,5,7]
        freqStack.push (4);//堆栈是 [5,7,5,7,4]
        freqStack.push (5);//堆栈是 [5,7,5,7,4,5]
        System.out.println(freqStack.pop());//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,5,7,4]。
        System.out.println(freqStack.pop());//返回 7 ，因为 5 和 7 出现频率最高，但7最接近顶部。堆栈变成 [5,7,5,4]。
        System.out.println(freqStack.pop());//返回 5 ，因为 5 出现频率最高。堆栈变成 [5,7,4]。
        System.out.println(freqStack.pop());//返回 4 ，因为 4, 5 和 7 出现频率最高，但 4 是最接近顶部的。堆栈变成


    }
}

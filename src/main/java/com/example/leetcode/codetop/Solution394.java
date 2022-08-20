package com.example.leetcode.codetop;

import java.util.*;

public class Solution394 {

    public String decodeString(String s) {

        Deque<Integer> numQue = new ArrayDeque<>();
        // 标准解是这里放String
        Deque<Character> charactersQue = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();
        int t = 0;
        boolean sign = false;
        StringBuilder stringInteger = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (Character.isDigit(charAt)) {
                stringInteger.append(charAt);
                sign = true;
                continue;
            }
            if (sign) {
                numQue.add(Integer.valueOf(stringInteger.toString()));
                stringInteger.delete(0, stringInteger.length());
            }
            sign = false;
            // 关于 [  [xxxx]] 与 [] []
            if (charAt == '[') {
                charactersQue.add(charAt);
                t++;
            } else if (charAt == ']') {
                StringBuilder cur = new StringBuilder();
                while (true) {
                    Character character = charactersQue.pollLast();
                    if (character == '[')
                        break;
                    cur.append(character);
                }
                t--;
                Integer times = numQue.pollLast();
                StringBuilder temp = new StringBuilder();
                for (int j = 0; j < times; j++) {
                    temp.append(cur);
                }
                String s1 = temp.reverse().toString();
                // 放回栈
                if (t > 0) {
                    for (int j = 0; j < s1.length(); j++) {
                        charactersQue.add(s1.charAt(j));
                    }
                } else {
                    res.append(s1);
                }
            } else {
                if (t == 0)
                    res.append(charAt);
                else
                    charactersQue.add(charAt);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]4[d]]xy";
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeStringOF2(s));
    }


    int ptr;

    public String decodeStringOF(String s) {
        LinkedList<String> stk = new LinkedList<String>();
        ptr = 0;

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);
            if (Character.isDigit(cur)) {
                // 获取一个数字并进栈
                String digits = getDigits(s);
                stk.addLast(digits);
            } else if (Character.isLetter(cur) || cur == '[') {
                // 获取一个字母并进栈
                stk.addLast(String.valueOf(s.charAt(ptr++)));
            } else {
                ++ptr;
                LinkedList<String> sub = new LinkedList<String>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }
                Collections.reverse(sub);
                // 左括号出栈
                stk.removeLast();
                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());
                StringBuffer t = new StringBuffer();
                String o = getString(sub);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }
                // 将构造好的字符串入栈
                stk.addLast(t.toString());
            }
        }
        return getString(stk);
    }

    public String getDigits(String s) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(s.charAt(ptr))) {
            ret.append(s.charAt(ptr++));
        }
        return ret.toString();
    }

    public String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }

    public String decodeStringOF2(String s) {
        StringBuffer ans = new StringBuffer();
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuffer> ansStack = new Stack<>();
        int multi = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) multi = multi * 10 + c - '0';
            // 用 [ 做分隔,stringbuild 做最小单位.
            else if (c == '[') {
                ansStack.add(ans);
                multiStack.add(multi);
                ans = new StringBuffer();
                multi = 0;
            } else if (Character.isAlphabetic(c)) {
                ans.append(c);
            } else {
                StringBuffer ansTmp = ansStack.pop();
                int tmp = multiStack.pop();
                for (int i = 0; i < tmp; i++) ansTmp.append(ans);
                ans = ansTmp;
            }
        }
        return ans.toString();
    }

}

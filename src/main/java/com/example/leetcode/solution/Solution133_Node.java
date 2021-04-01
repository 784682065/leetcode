package com.example.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

class Solution133_Node {
    public int val;
    public List<Solution133_Node> neighbors;
    public Solution133_Node() {
        val = 0;
        neighbors = new ArrayList<Solution133_Node>();
    }
    public Solution133_Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Solution133_Node>();
    }
    public Solution133_Node(int _val, ArrayList<Solution133_Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

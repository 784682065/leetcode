package com.example.leetcode.test;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-28 16:49
 */
public class Edge<E> {
    E data;
    int fromVertexIndex;
    int toVertexIndex;
    Edge<E> nextSameFromVertex;
    Edge<E> nextSameToVertex;

    public Edge(E data, int fromVertexIndex, int toVertexIndex) {
        this.data = data;
        this.fromVertexIndex = fromVertexIndex;
        this.toVertexIndex = toVertexIndex;
    }
}

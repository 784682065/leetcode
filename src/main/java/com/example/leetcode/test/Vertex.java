package com.example.leetcode.test;

/**
 * describe:
 *
 * @Author: Huzp
 * @Date: 2020-04-28 16:49
 */
public class Vertex<E,T>  {
    E data;
    Edge<T> firstIn;
    Edge<T> firstOut;

    public Vertex(E data) {
        this.data = data;
    }
}

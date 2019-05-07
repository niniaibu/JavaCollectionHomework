package com.thoughtworks.collection;

public interface SingleLink<T> {
    void addTailPointer(T item);         //添加尾指针
    T getNode(int index);
}
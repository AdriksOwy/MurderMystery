package com.murder.objects;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SynchronizedQueue<T> {
    private LinkedList<T> list;

    public synchronized void push(T value){
        list.add(value);
    }
    public synchronized T pop() throws NoSuchElementException {
        return list.pop();
    }

    public SynchronizedQueue(){
        list = new LinkedList<T>();
    }
}

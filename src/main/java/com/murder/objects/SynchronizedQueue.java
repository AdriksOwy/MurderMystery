package com.murder.objects;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SynchronizedQueue<T> {
    private LinkedList<T> list;

    public synchronized void push(T o) {

        list.add(o);
    }
    public synchronized T pop() throws NoSuchElementException {

        return list.pop();
    }
    public int size() {

        return list.size();
    }

    public SynchronizedQueue() {

        list = new LinkedList<T>();
    }
}

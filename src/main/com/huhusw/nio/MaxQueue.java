package com.huhusw.nio;

public interface MaxQueue {
    public void add(int v);

    public int poll();

    public int pollMax();
}

package com.company;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {
    private String name;
    private int count;

    public NamedThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        count++;
        ThreadFactory factory = Thread.builder().virtual().factory(); //Executors.defaultThreadFactory();
        Thread t = factory.newThread(r);
        t.setName(name + "-" + count);
        System.out.println("New thread " + t);
        return t;
    }
}

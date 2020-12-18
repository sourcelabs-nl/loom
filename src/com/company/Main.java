package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        System.out.println("Java version: " + System.getProperty("java.version"));
        final ThreadFactory factory = Thread.builder().virtual().factory();
        final int NTASKS = 10000000;
        ExecutorService exec = Executors.newFixedThreadPool(1000000000);
        //Executors.newFixedThreadPool(1000, factory);

        for (int i = 1; i <= NTASKS; i++) {
            String taskname = "task-" + i;
            exec.submit(() -> run(taskname));
        }
        exec.shutdown();
        exec.awaitTermination(1000, TimeUnit.MILLISECONDS);

    }

    public static int DELAY = 10_0;

    public static void run(Object obj) {
        try {
            Thread.sleep((int) (DELAY * Math.random()));
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println(obj);
    }


}

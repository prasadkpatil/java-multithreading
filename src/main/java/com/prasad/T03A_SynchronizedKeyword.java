package com.prasad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T03A_SynchronizedKeyword {

    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private synchronized void stageOne() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100));
    }

    private synchronized void stageTwo() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100));
    }

    private void process() {
        for (int i = 0; i < 1000; i++) {
            stageOne();
            stageTwo();
        }
    }

    public void main() {
        System.out.println("Starting Threads...");

        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                process();
            }
        });

        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                process();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("List1 size: " + list1.size() + ", List2 size: " + list2.size());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        T03A_SynchronizedKeyword worker = new T03A_SynchronizedKeyword();
        worker.main();
        
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime));
    }
}

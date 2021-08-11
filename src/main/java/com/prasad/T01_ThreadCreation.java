package com.prasad;

/**
 * Hello world!
 *
 */
public class T01_ThreadCreation {
    public static void main(String[] args) {
        // Extending Thread class
        System.out.println("Threads created using extending Thread class");
        Runner runner1 = new Runner();
        Runner runner2 = new Runner();
        runner1.start();
        runner2.start();

        // Implementing Runnable interface
        System.out.println("Threads created using Implementing Runnable interface");
        Thread runner3 = new Thread(new Runner1());
        Thread runner4 = new Thread(new Runner1());
        runner3.start();
        runner4.start();

        // Annonymus class
        System.out.println("Threads created using Annonymus class");
        Thread runner = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Hello " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        runner.start();
    }
}

// Extending Thread class
class Runner extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Implementing Runnable interface
class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hello " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

package com.prasad;

import java.util.Scanner;

class Processor extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello ");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        this.running = false;
    }
}

public class VolatileKeywordDemo {
    public static void main(String[] args) {
        Processor p = new Processor();
        p.start();

        System.out.println("Enter Return to stop...");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();

        p.shutdown();
        scan.close();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * @author DashaCh
 */
public class MyRunnable implements Runnable {

    public void run() {
        try {
            for (int i = 10; i > 0; i--) {
                System.out.println("child thread " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("child interrupted");
        }
        System.out.println("exiting child thread");
    }

    public static void main(String args[]) {
        Runnable r = new MyRunnable();
        Thread t = new Thread(r);
        t.start();

        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Main thread " + i);
                Thread.sleep(1000);
            }
            t.join();
        } catch (InterruptedException e) {
            System.out.println("Main interrupted");
        }
        System.out.println("exiting Main thread");
    }
}

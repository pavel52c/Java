/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class SimpleThread extends Thread {
    private int countDown = 5;

    public SimpleThread(int threadNumber) {
        System.out.println("Making " + threadNumber);
        this.setName("SimpleThread " + threadNumber);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("  " +
                    currentThread().getName() + "(" + countDown + ")");
            if (--countDown == 0) return;
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++)
            new SimpleThread(i).start();
        System.out.println("All Threads Started");
    }
} 

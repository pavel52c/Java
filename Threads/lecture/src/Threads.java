/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author DashaCh
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Thread t = Thread.currentThread();
        System.out.println("id =" + t.getId());
        System.out.println("name =" + t.getName());
        System.out.println("priority =" + t.getPriority());
        System.out.println("state =" + t.getState());
        System.out.println("isAlive =" + t.isAlive());
        System.out.println("isDeamon =" + t.isDaemon());
        System.out.println("isInterrupted =" + t.isInterrupted());
        System.out.println(t.toString());
        System.out.println("Causes the currently executing thread to sleep");
        try {
            t.sleep(10000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Main thread continue work");
        System.out.println(t.toString());
    }
}

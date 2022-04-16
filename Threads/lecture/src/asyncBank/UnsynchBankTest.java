/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asyncBank;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author User
 */
public class UnsynchBankTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
        int i;
        long t1 = System.currentTimeMillis();
        Thread t[] = new Thread[NACCOUNTS];
        System.out.println("begin = " + t1);
        for (i = 0; i < NACCOUNTS; i++) {
            TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
            t[i] = new Thread(r);
            t[i].start();
            //   t[i].join();
        }
        BalanceRunnable bl = new BalanceRunnable(b);
        Thread tb = new Thread(bl);
        tb.start();
        try {
            for (i = 0; i < NACCOUNTS; i++) {

                t[i].join();
            }
//    tb.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(UnsynchBankTest.class.getName()).log(Level.SEVERE, null, ex);

        }
        long t2 = System.currentTimeMillis();
        System.out.println("end = " + t2);
        System.out.println("time = " + (t2 - t1));
    }

    public static final int NACCOUNTS = 5;
    public static final double INITIAL_BALANCE = 1000;

}

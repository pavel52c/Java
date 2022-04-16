/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asyncBank;

/**
 *
 * @author User
 */
public class TransferRunnable implements Runnable{
  public TransferRunnable(Bank b, int from, double max){
    bank = b;
    fromAccount = from;
    maxAmount = max;
  }
  public void run() {
   try {
     for (int j=0; j<10; j++){
       int toAccount = (int) (bank.size() * Math.random());
       double amount = maxAmount * Math.random();
      if (fromAccount!=toAccount)
          bank.transfer(fromAccount, toAccount, amount);
       Thread.sleep((int) (DELAY * Math.random()));
      }
    } catch (InterruptedException e ){}
   System.out.println(Thread.currentThread()+" FINISH");
  }
  private Bank bank;
  private int fromAccount;
  private double maxAmount;
  private int DELAY = 5;
}

class BalanceRunnable implements Runnable{
  public BalanceRunnable(Bank b){
    bank = b;
  }
  public void run() {
   try {
     for (int j=0; j<12; j++){
         System.out.println("monthly balance "+ j +" "+bank.getTotalBalance());
          Thread.sleep((int) (DELAY * Math.random()));
      }
     } catch (InterruptedException e ){}
   System.out.println(Thread.currentThread()+" Balance  leased");
  }

    private Bank bank;
     private int DELAY = 10;
}
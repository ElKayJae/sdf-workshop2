package vtp2022.day2;

import account.BankAccount;
import account.FixedDepositAccount;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //Bank Account Test
        System.out.println( "My ATM Machine - POSSBank" );
        BankAccount bkAcc = new BankAccount("KJ Account");
        bkAcc.deposit("1000");
        System.out.println("My new accout balance >"+bkAcc.getBalance());
        bkAcc.deposit("500");
        System.out.println("My new accout balance >"+bkAcc.getBalance());
        System.out.println("Withdraw 20 -> my new account balance >" + bkAcc.withdraw("20"));
        System.out.println("Withdraw 500 -> my new account balance >" + bkAcc.withdraw("500"));

        //FixedDdepositAccount test

        FixedDepositAccount fdAcc= new FixedDepositAccount("My FD acc", 10000);

        System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setInterestAndDuration(4, 12);
        System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setInterestAndDuration(5,6); 
    }
}

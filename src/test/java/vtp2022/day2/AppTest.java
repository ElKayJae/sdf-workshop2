package vtp2022.day2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import account.BankAccount;
import account.FixedDepositAccount;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAcccount()
    {
            BankAccount bkAcc = new BankAccount("KJ Account");
            bkAcc.deposit("1000");
            float finalBalance = bkAcc.withdraw("500");
            assertEquals(500, finalBalance, 0);
        
    }

    @Test
    public void testFixedDepositAccountChangeInterestAndDuration(){
        try {
            FixedDepositAccount fdAcc= new FixedDepositAccount("My FD acc", 10000);
            
            System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setInterestAndDuration(4, 12);
            System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setInterestAndDuration(5,6); 
            
        } catch (IllegalArgumentException e) {
            assertTrue("Only can set duration and interest once.".equals(e.getMessage()));
        }
    }
    //test 
    @Test
    public void testFixedDepositAccountChangeInterestAndDurationOnce(){
        try {
            FixedDepositAccount fdAcc= new FixedDepositAccount("My FD acc", 10000);
            
            System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setInterestAndDuration(4, 12);
            System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setInterestAndDuration(5,6); 
            
        } catch (IllegalArgumentException e) {
            assertTrue("Only can set duration and interest once.".equals(e.getMessage()));
        }
    }

    
}

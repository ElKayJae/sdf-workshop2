package account;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class BankAccount {
    //Declaration
    private String name = "";
    private String accId = UUID.randomUUID().toString().substring(0,8);
    private float balance = 0f;
    private List<String> transaction = new LinkedList<>();
    private boolean isClosed = false;
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    //Constructor
    public BankAccount(String name){
        this.name = name;
        this.balance = 0;
    }
    //Constructor
    public BankAccount(String name, float initialBal){
        this.name = name;
        this.balance = initialBal;
    }
    
    
    // Getter and setter for the rest of the properties (source action)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }
    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }
    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }
    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }


    //Methods 

    public float withdraw(String withdrawAmt){

        Float withdrawAmtF =null;

        try {
            withdrawAmtF = Float.parseFloat(withdrawAmt);
            if (withdrawAmtF.floatValue() <= 0) {
                throw new IllegalArgumentException("Withdrawal cannot be negative or zero");
            }
            if (this.isClosed()){
                throw new IllegalArgumentException("This account is closed");
            }

            if(withdrawAmtF.floatValue() > this.balance){
                throw new IllegalArgumentException("Insufficient Value!");
            }

            //Transaction happens first
            this.balance = this.balance - withdrawAmtF.floatValue();
            //pull from transaction
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Withdraw $");
            txnStrbld.append(withdrawAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            transaction.add(txnStrbld.toString());
            
        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdraw amount");
        }

        return this.balance;
    }

    public void deposit(String depositAmt){
        try {
            Float depositAmtF = Float.parseFloat(depositAmt);
            if (depositAmtF.floatValue() <= 0) {
                throw new IllegalArgumentException("Deposit cannot be negative or zero");
            }
            if (this.isClosed()){
                throw new IllegalArgumentException("This account is closed");
            }
            //Transaction happens first
            this.balance = this.balance + depositAmtF.floatValue();
            //pull from transaction
            StringBuilder txnStrbld = new StringBuilder();
            txnStrbld.append("Deposit $");
            txnStrbld.append(depositAmtF.floatValue());
            txnStrbld.append(" at ");
            txnStrbld.append(LocalDateTime.now());
            System.out.println(txnStrbld.toString());
            transaction.add(txnStrbld.toString());
            
        } catch (NumberFormatException e) {
            System.err.print(e);
            throw new IllegalArgumentException("Invalid deposit amount");
        }
        

    }
}

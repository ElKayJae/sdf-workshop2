package account;

public class FixedDepositAccount extends BankAccount{
    
    private float interest = 3;
    private int duration = 6;
    private int durationInterestCounter;


    public FixedDepositAccount(String name, float initialAmount){
        super(name, initialAmount);
        this.durationInterestCounter = 0;
    }

    public FixedDepositAccount(String name, float initialAmount, float interest){
        super(name, initialAmount);
        this.interest = interest;
        this.durationInterestCounter = 0;
    }

    public FixedDepositAccount(String name, float initialAmount, float interest, int duration){
        super(name, initialAmount);
        this.interest = interest;
        this.duration = duration;
        this.durationInterestCounter = 0;
    }

    

    public int getDuration() {
        return duration;
    }

    private void setDuration(int duration) {
        if(duration < 0){
            throw new IllegalArgumentException("unsupported duration.");
        }
        this.duration = duration;
    }

    private void setInterest(float interest) {
        if(interest < 0){
            throw new IllegalArgumentException("unsupported interest.");
        }
        this.interest = interest;
    }

    public void setInterestAndDuration(float interest, int duration){
        if (durationInterestCounter == 1){
            throw new IllegalArgumentException("Only can set duration and interest once.");
        }
        setInterest(interest);
        setDuration(duration);
    }

    @Override
    public float withdraw(String withdrawAmt){
        //NOP
        return 0;
    }
    
    @Override
    public void deposit (String depositAmt){
        //NOP
    }

    @Override
    public float getBalance(){
        return super.getBalance() + interest;
    }



}

package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;
    double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        super();
        this.setName(name);
        this.setBalance(balance);
        this.rate=rate;
        this.maxWithdrawalLimit=maxWithdrawalLimit;

        // minimum balance is 0 by default
        this.setMinBalance(0);

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(amount>maxWithdrawalLimit){
            throw new Exception("Maximum Withdraw Limit Exceed");
        }
        if(amount>getBalance()){
            throw new InsufficientBalance("Insufficient Balance");
        }
        setBalance(-amount);
    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double interest=0.0;
        double res=rate*years;
        interest=getBalance()*(1+res);
        return interest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double interest=0.0;
        double res=rate/times;
        double pow=times*years;
        interest=getBalance()*(Math.pow((1+res),pow));

        return interest;
    }

}

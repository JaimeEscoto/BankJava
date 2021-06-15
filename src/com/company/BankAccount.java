package com.company;
public class BankAccount {

    private int id;
    private String owner;
    private double accountBalance;
    private String history;
    private String currency;

    public BankAccount(String ownerParam)
    {
        owner=ownerParam;
        accountBalance=0.0;
        history="Account Created ";
        currency = "L";
    }
    public BankAccount(String ownerParam, String currencyParam)
    {
        owner=ownerParam;
        accountBalance=0.0;
        history="Account Created ";
        if(currencyParam=="L" || currencyParam=="$") {
            currency = currencyParam;
        }
        else
        {
            currency = "L";

        }
    }


    public double getAccountBalance() {
        return accountBalance;
    }

    public String getHistory() {
        return history;
    }

    public String getOwner() {
        return owner;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setHistory(String history) {
        this.history = history;
    }
    public void deposit(double amount)
    {
        this.accountBalance = this.accountBalance + amount;
        addHistory("Deposit Succed: "+amount);
    }

    public boolean withdraw(double amount)
    {
        if(this.accountBalance>=amount)
        {
            this.accountBalance = this.accountBalance - amount;
            addHistory("Withdaw Succed: "+amount);
            return true;
        }
        addHistory("Withdaw Failed: "+amount);
        return false;
    }
    private void addHistory(String info)
    {
     this.history=this.history + " - "+info ;
    }

    public void setId(int id) {
        this.id = id;
        addHistory("Id Modified: "+id);
    }

    public int getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }
}

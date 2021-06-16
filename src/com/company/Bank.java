package com.company;

import org.jetbrains.annotations.Nullable;

public class Bank {

    private String bankName;
    // Empleado arrayObjetos[]=new Empleado[3];
    private BankAccount[] bankAccounts;
    private int bankAccountsQty;
    private int bankAccountsCreated;
    private double coversionFactor;


    public Bank(String BankNameParam, int bankAccountsQtyParam)
    {
       bankName=BankNameParam;
       bankAccounts = new BankAccount[bankAccountsQtyParam];
       bankAccountsQty=bankAccountsQtyParam;
       bankAccountsCreated=0;
       coversionFactor=24.18;
    }

    public String getBankName() {
        return bankName;
    }

    public int getBankAccountsQty() {
        return bankAccountsQty;
    }
    public boolean addBankAccount(BankAccount bankAccountParam)
    {
        // Revisar si la cuenta cabe en el arreglo
        // Asignarle el id a la cuenta nueva
        // Agregarla en la posicion del arreglo

        if (bankAccountsCreated < bankAccountsQty) {
            bankAccountParam.setId(bankAccountsCreated);
            bankAccountsCreated++;
            bankAccounts[bankAccountParam.getId()] = bankAccountParam;
            return true;
        }


        return false;
    }
    public boolean addBankAccount(String accountOwnerParam)
    {
        BankAccount temporalAccount = new BankAccount(accountOwnerParam);
        return addBankAccount(temporalAccount);

    }

    public BankAccount[] getBankAccounts() {
        return bankAccounts;
    }

    public boolean depositMoney(int idBankAccountParam, double amountParam)
    {
        //
        BankAccount tempBankAccount;
        for (int i = 0; i < bankAccountsCreated; i++) {
            tempBankAccount = bankAccounts[i];
            if(tempBankAccount.getId()==idBankAccountParam)
            {
                tempBankAccount.deposit(amountParam);
                return true;
            }
        }
        return false;
    }
    public boolean withdrawMoney(int idBankAccountParam, double amountParam)
    {
        BankAccount tempBankAccount;
        for (int i = 0; i < bankAccountsCreated; i++) {
            tempBankAccount = bankAccounts[i];
            if(tempBankAccount.getId()==idBankAccountParam)
            {
                if (tempBankAccount.getAccountBalance()>=amountParam)
                {
                    tempBankAccount.withdraw(amountParam);
                    return true;
                }
            }
        }
        return false;
    }
    private boolean tranferMoneyBetweenAccounts(BankAccount origin, BankAccount destination, double amountParam)
    {
        boolean withdrawResult = origin.withdraw(amountParam);
        if (withdrawResult)
        {
            if (origin.getCurrency()=="L")
            {
                destination.deposit(amountParam/coversionFactor);
            }
            else
            {
                destination.deposit(amountParam*coversionFactor);
            }
            return true;
        }
        return false;
    }
    public boolean tranferMoneyBetweenAccounts(int idOriginBankAccountParam, int idDestinationBankAccountParam, double amountParam )
    {
        BankAccount tempOriginBankAccount = findBankAcountById(idOriginBankAccountParam);

        if (tempOriginBankAccount==null)
        {
            return false;
        }

        BankAccount tempDestinationBankAccount= findBankAcountById(idDestinationBankAccountParam);

        if (tempDestinationBankAccount==null)
        {
            return false;
        }

        boolean withdrawResult;

        if (tempOriginBankAccount.getCurrency() == tempDestinationBankAccount.getCurrency())
        {
            withdrawResult = tempOriginBankAccount.withdraw(amountParam);
            if(withdrawResult)
            {
                tempDestinationBankAccount.deposit(amountParam);
                return true;
            }
        }
        else
        {
            return tranferMoneyBetweenAccounts(tempOriginBankAccount,tempDestinationBankAccount,amountParam);
        }
        return false;
    }
    private @Nullable
    BankAccount findBankAcountById(int bankAccountIdParam)
    {
        BankAccount temporalBankAccount=null;
        for (int i = 0; i < bankAccountsCreated; i++) {
            if( bankAccounts[i].getId()==bankAccountIdParam)
            {
                temporalBankAccount = bankAccounts[i];
                return temporalBankAccount;
            }

        }
        return null;
    }



}

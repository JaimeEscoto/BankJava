package com.company;

public class Bank {

    private String bankName;
    // Empleado arrayObjetos[]=new Empleado[3];
    private BankAccount[] bankAccounts;
    private int bankAccountsQty;
    private int bankAccountsCreated;


    public Bank(String BankNameParam, int bankAccountsQtyParam)
    {
       bankName=BankNameParam;
       bankAccounts = new BankAccount[bankAccountsQtyParam];
       bankAccountsQty=bankAccountsQtyParam;
       bankAccountsCreated=0;
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


}

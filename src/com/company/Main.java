package com.company;

public class Main {
    public static void printAccounts(BankAccount[] bankAccounts)
    {
        int counter=0;
        while (counter < bankAccounts.length )
        {
            System.out.println("-------------------");
            System.out.println("Id: "+ bankAccounts[counter].getId() );
            System.out.println("Owner: "+ bankAccounts[counter].getOwner() );
            System.out.println("Account Balance: "+ bankAccounts[counter].getAccountBalance() );
            System.out.println("Currency: "+ bankAccounts[counter].getCurrency() );
            System.out.println("History: "+ bankAccounts[counter].getHistory() );


            counter++;
        }

    }
    public static void main(String[] args) {
	// write your code here

        int cantidadCuentas = 2;
        String nombreBanco = "Banco America";
        boolean flag;
        Bank miBanco =  new Bank(nombreBanco,cantidadCuentas);
        BankAccount cuenta1 = new BankAccount("Jaime","$");
        BankAccount cuenta2 = new BankAccount("Lourdes","$");
        miBanco.addBankAccount(cuenta1);
        miBanco.addBankAccount(cuenta2);

        miBanco.depositMoney(1,100);
        miBanco.depositMoney(0,500);
        printAccounts(miBanco.getBankAccounts());
        boolean result=miBanco.tranferMoneyBetweenAccounts(5,1,1000);
        if(!result)
        {
            System.out.println("Error en la transferencia");
        }

        printAccounts(miBanco.getBankAccounts());
    }

}

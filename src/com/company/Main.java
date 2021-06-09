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

        BankAccount micuenta1 = new BankAccount("Jaime");
        flag=miBanco.addBankAccount(micuenta1);
        System.out.println(flag);
        //CuentaBancaria micuenta2 = new CuentaBancaria("Lourdes");
        flag=miBanco.addBankAccount("Lourdes");
        System.out.println(flag);
        BankAccount micuenta3 = new BankAccount("Gabriel");
        flag=miBanco.addBankAccount(micuenta3);
        System.out.println(flag);

        BankAccount[] bankAccounts = miBanco.getBankAccounts();

        printAccounts(miBanco.getBankAccounts());

        boolean resultadoDeposito;
        resultadoDeposito=miBanco.depositMoney(77,100000);
        if(resultadoDeposito)
        {
            System.out.println("Deposito exitoso");
        }
        else
        {
            System.out.println("Deposito fallido");
        }



        resultadoDeposito=miBanco.depositMoney(1,555555);

        printAccounts(miBanco.getBankAccounts());

        resultadoDeposito=miBanco.withdrawMoney(1,5000);
        if(resultadoDeposito)
        {
            System.out.println("Retiro exitoso");
        }
        else
        {
            System.out.println("Retiro fallido");
        }
        printAccounts(miBanco.getBankAccounts());
    }

}

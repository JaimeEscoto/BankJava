package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int cantidadCuentas = 1;
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
        int counter=0;
        while (counter < bankAccounts.length )
        {
            System.out.println("Id"+ bankAccounts[counter].getId() );
            System.out.println("Owner"+ bankAccounts[counter].getOwner() );

            counter++;
        }

    }
}

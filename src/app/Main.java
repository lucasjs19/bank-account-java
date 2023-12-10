package app;

import model.entities.Account;
import model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Locale.setDefault(Locale.US);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = sc.nextInt();
            sc.nextLine();
            System.out.print("Holder: ");
            String name = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = sc.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(number, name, balance, withdrawLimit);

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double withdrawAmount = sc.nextDouble();
            account.withdraw(withdrawAmount);
            System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));

            sc.close();
        }catch (BusinessException e){
            System.out.println(e.getMessage());
        }catch (RuntimeException e){
            System.out.println("Unexpected error.");
        }
    }
}
package com.company;
import java.util.Scanner;
class BankAccount{
    private double balance;

    public BankAccount(double initialBalance){
        balance=initialBalance;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amount){
        if(amount>0){
            balance = balance+amount;
            System.out.println("Deposit successfully through bank.New balance: "+balance);
        }
        else {
            System.out.println("invalid amount for deposit: ") ;

        }
    }
    public void withDraw(double amount){
        if (amount>0 && amount <=balance){
            balance = balance-amount;
            System.out.println("withdraw successfully through checkbook. New balance: "+ balance);
        }
        else {
            System.out.println("insufficient balance or invalid amount for withdraw.");
        }
    }
}
class ATM {
    private final BankAccount account;
    private final Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        scanner = new Scanner(System.in);
    }

    public void DisplayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Balance Inquiry");
        System.out.println("2. Deposit Money");
        System.out.println("3. Quick Withdrawal ");
        System.out.println("4. Exit");

    }

    public void run() {
        int choice;
        do {
            DisplayMenu();
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> System.out.println("current balance: " + account.getBalance());
                case 2 -> {
                    System.out.println("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                }
                case 3 -> {
                    System.out.println("Enter Withdrawl amount: ");
                    double withDrawlAmount = scanner.nextDouble();
                    account.withDraw(withDrawlAmount);
                }
                case 4 -> System.out.println("Exit ATM. Thank you!");
                default -> System.out.println("invalid choice. please select a valid option.");
            }
        }
        while (choice != 4);
    }
}

public class Task4 {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000);
        ATM a1= new ATM(userAccount);
        a1.run();
    }
}
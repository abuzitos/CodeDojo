/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.codedojo.projetoIA.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abu
 */
public class Account implements AccountService {
    private int balance;
    private final List<String> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(int amount, LocalDate date) {
        if (amount > 0) {
            balance += amount;
            //transactions.add("Deposited: " + amount + " on " + date);
            transactions.add("Date: " + date + " || " +
                             "Amount: " + amount + " ||" +
                             "Balance " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    @Override
    public void withdraw(int amount, LocalDate date) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Date: " + date + " || " +
                             "Amount: " + amount + " ||" +
                             "Balance " + balance);
        } else {
            //System.out.println("Invalid withdraw amount.");
            transactions.add("Date: " + date + " || " +
                             "Amount: " + amount + " ||" +
                             "Balance " + balance + " || " +
                             "ERROR: Insufficient funds");
        }
    }

    @Override
    public void printStatement() {
        System.out.println("<EXTRATO>");
        System.out.println("Current balance: " + balance);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Override
    public int getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(500, LocalDate.now());
        account.withdraw(50, LocalDate.now());
        account.withdraw(350, LocalDate.now());
        account.withdraw(100, LocalDate.now());
        account.printStatement();
    }
}

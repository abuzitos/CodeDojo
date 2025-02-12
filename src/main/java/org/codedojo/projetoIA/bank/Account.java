/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.codedojo.projetoIA.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * A classe Account representa uma conta bancária com funcionalidades básicas
 * como depósito, retirada e impressão de extrato.
 *
 * @author abu
 */

/**
 * @openapi
 * components:
 *   schemas:
 *     Account:
 *       type: object
 *       properties:
 *         balance:
 *           type: integer
 *           description: O saldo atual da conta.
 *         transactions:
 *           type: array
 *           items:
 *             type: string
 *           description: A lista de transações realizadas na conta.
 */
public class Account implements AccountService {
    private int balance;
    private final List<String> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    /**
     * @openapi
     * /account/deposit:
     *   post:
     *     summary: Deposita um valor na conta.
     *     requestBody:
     *       required: true
     *       content:
     *         application/json:
     *           schema:
     *             type: object
     *             properties:
     *               amount:
     *                 type: integer
     *                 description: O valor a ser depositado.
     *               date:
     *                 type: string
     *                 format: date
     *                 description: A data do depósito.
     *     responses:
     *       200:
     *         description: Depósito realizado com sucesso.
     */
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

    /**
     * @openapi
     * /account/withdraw:
     *   post:
     *     summary: Retira um valor da conta.
     *     requestBody:
     *       required: true
     *       content:
     *         application/json:
     *           schema:
     *             type: object
     *             properties:
     *               amount:
     *                 type: integer
     *                 description: O valor a ser retirado.
     *               date:
     *                 type: string
     *                 format: date
     *                 description: A data da retirada.
     *     responses:
     *       200:
     *         description: Retirada realizada com sucesso.
     *       400:
     *         description: Fundos insuficientes.
     */
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

    /**
     * @openapi
     * /account/printStatement:
     *   get:
     *     summary: Imprime o extrato da conta.
     *     responses:
     *       200:
     *         description: Extrato impresso com sucesso.
     */
    @Override
    public void printStatement() {
        System.out.println("<EXTRATO>");
        System.out.println("Current balance: " + balance);
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    /**
     * @openapi
     * /account/balance:
     *   get:
     *     summary: Retorna o saldo atual da conta.
     *     responses:
     *       200:
     *         description: Saldo retornado com sucesso.
     *         content:
     *           application/json:
     *             schema:
     *               type: integer
     *               description: O saldo atual da conta.
     */
    @Override
    public int getBalance() {
        return balance;
    }

    /**
     * @openapi
     * /account/transactions:
     *   get:
     *     summary: Retorna a lista de transações realizadas na conta.
     *     responses:
     *       200:
     *         description: Lista de transações retornada com sucesso.
     *         content:
     *           application/json:
     *             schema:
     *               type: array
     *               items:
     *                 type: string
     *               description: A lista de transações realizadas na conta.
     */
    public List<String> getTransactions() {
        return transactions;
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(500, LocalDate.now());
        account.withdraw(50, LocalDate.now());
        account.withdraw(350, LocalDate.now());
        account.withdraw(100, LocalDate.now());
        account.printStatement();
    }

    // criar um metodo que realiza a saida do extrato em um arquivo yaml
    public void printStatementJson() {
        System.out.println("{");
        System.out.println("\"balance\": " + balance + ",");
        System.out.println("\"transactions\": [");
        for (String transaction : transactions) {
            System.out.println("\"" + transaction + "\",");
        }
        System.out.println("]");
        System.out.println("}");
    }

}

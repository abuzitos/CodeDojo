/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package org.codedojo.projetoIA.bank;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testDeposit() {
        account.deposit(100, LocalDate.now());
        assertEquals(100, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(100, LocalDate.now());
        account.withdraw(50, LocalDate.now());
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(50, LocalDate.now());
        account.withdraw(100, LocalDate.now());
        assertEquals(50, account.getBalance());
    }

    @Test
    public void testPrintStatement() {
        account.deposit(100, LocalDate.now());
        account.withdraw(50, LocalDate.now());
        account.printStatement();
        // This test is just to ensure the method runs without errors
    }

    /*
        Given a client makes a deposit of 1000 on 10-01-2012
        And a deposit of 2000 on 13-01-2012
        And a withdrawal of 500 on 14-01-2012
        When they print their bank statement
        Then they would see:

        Date       || Amount || Balance
        14/01/2012 || -500   || 2500
        13/01/2012 || 2000   || 3000
        10/01/2012 || 1000   || 1000
     */
    @Test
    public void testPrintStatementMultipleTransactions() {
        account.deposit(1000, LocalDate.of(2012, 1, 10));
        account.deposit(2000, LocalDate.of(2012, 1, 13));
        account.withdraw(500, LocalDate.of(2012, 1, 14));
        account.printStatement();
        // This test is just to ensure the method runs without errors
    }
}
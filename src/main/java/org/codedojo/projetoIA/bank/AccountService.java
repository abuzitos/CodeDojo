/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package org.codedojo.projetoIA.bank;

/**
 *
 * @author abu
 */
import java.time.LocalDate;

public interface AccountService {
    void deposit(int amount, LocalDate date);
    void withdraw(int amount, LocalDate date);
    int getBalance();
    void printStatement();
}
package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();

        System.out.println("Test 1 : Dépôts et retraits normaux\n");
        try {
            account.deposit(1000, LocalDate.of(2012, 1, 10));
            account.deposit(2000, LocalDate.of(2012, 1, 13));
            account.withdraw(500, LocalDate.of(2012, 1, 14));
            account.printStatement();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nTest 2 : Dépôt négatif\n");
        try {
            account.deposit(-100);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nTest 3 : Retrait négatif\n");
        try {
            account.withdraw(-50);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nTest 4 : Retrait plus grand que solde\n");
        try {
            account.withdraw(10000);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nTest 5 : Relevé vide (nouveau compte)\n");
        Account newAccount = new Account();
        newAccount.printStatement();

        System.out.println("\nTest 6 : Transactions avec même date\n");
        try {
            Account sameDateAccount = new Account();

            sameDateAccount.deposit(1000, LocalDate.of(2012, 1, 5));
            sameDateAccount.withdraw(200, LocalDate.of(2012, 1, 5));
            sameDateAccount.deposit(300, LocalDate.of(2012, 1, 5));
            sameDateAccount.printStatement();
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\nTest 7 : Montant zéro\n");
        try {
            account.deposit(0);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
        try {
            account.withdraw(0);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}

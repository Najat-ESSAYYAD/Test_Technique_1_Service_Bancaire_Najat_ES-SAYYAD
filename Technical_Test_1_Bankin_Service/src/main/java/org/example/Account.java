package org.example;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Account implements AccountService{

    private final List<Transaction> transactions = new ArrayList<>();
    private int currentBalance = 0;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Dépôt avec date du jour par défaut
    @Override
    public void deposit(int amount) {
        deposit(amount, LocalDate.now());
    }

    // Surcharge avec date spécifique (utile pour tests)
    public void deposit(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du dépôt doit être positif.");
        }
        currentBalance += amount;
        transactions.add(new Transaction(date, amount, currentBalance));
    }

    @Override
    // Retrait avec date du jour par défaut
    public void withdraw(int amount) {
        withdraw(amount, LocalDate.now());
    }

    // Surcharge avec date spécifique
    public void withdraw(int amount, LocalDate date) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant du retrait doit être positif.");
        }
        if (amount > currentBalance) {
            throw new IllegalArgumentException("Fonds insuffisants pour le retrait.");
        }
        currentBalance -= amount;
        transactions.add(new Transaction(date, -amount, currentBalance));
    }
    @Override
    public void printStatement() {
        System.out.println("Date       || Amount || Balance");

        // Trier les transactions par date décroissante
        List<Transaction> sorted = new ArrayList<>(transactions);
        sorted.sort(Comparator.comparing((Transaction t) -> t.getDate()).reversed());

        for (Transaction t : sorted) {
            System.out.printf("%s || %d   || %d%n", t.getDate().format(formatter), t.getAmount(), t.getBalance());
        }
    }
}

package edu.sharif.selab;

import java.util.ArrayList;
import java.util.List;

public class AccountBalanceCalculator {

    private static List<Transaction> transactionHistory = new ArrayList<>();


    public static int calculateBalance(List<Transaction> transactions) {
        int balance = 0;

        clearTransactionHistory();
        
        for (Transaction t : transactions) {
            if (t.getType() == TransactionType.DEPOSIT) {
                balance += t.getAmount();
                addTransaction(t);
            } else if (t.getType() == TransactionType.WITHDRAWAL) {
                if (balance >= t.getAmount()) {
                    balance -= t.getAmount();
                    addTransaction(t);
                }
                else{
                    System.out.println("You don't have enough balance!");
                }
            }
        }
        return balance;
    }


    // Method to get the transaction history
    public static List<Transaction> getTransactionHistory() {
        return new ArrayList<>(transactionHistory); // Return a copy to prevent external modification
    }

    // Method to add a transaction to the history
    public static void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    // Method to clear the transaction history
    public static void clearTransactionHistory() {
        transactionHistory.clear();
    }
}

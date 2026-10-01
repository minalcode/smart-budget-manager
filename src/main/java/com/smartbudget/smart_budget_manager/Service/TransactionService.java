package com.smartbudget.smart_budget_manager.Service;

import com.smartbudget.smart_budget_manager.Model.Transaction;
import com.smartbudget.smart_budget_manager.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Long id, Transaction transaction) {

        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        existingTransaction.setTitle(transaction.getTitle());
        existingTransaction.setAmount(transaction.getAmount());
        existingTransaction.setType(transaction.getType());
        existingTransaction.setDate(transaction.getDate());
        existingTransaction.setDescription(transaction.getDescription());
        existingTransaction.setCategory(transaction.getCategory());

        return transactionRepository.save(existingTransaction);
    }

    public void deleteTransaction(Long id) {

        if (!transactionRepository.existsById(id)) {
            throw new RuntimeException("Transaction not found");
        }

        transactionRepository.deleteById(id);
    }
}
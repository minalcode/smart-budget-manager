package com.smartbudget.smart_budget_manager.Service;

import com.smartbudget.smart_budget_manager.Model.Budget;
import com.smartbudget.smart_budget_manager.Repository.BudgetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BudgetService {

    private final BudgetRepository budgetRepository;

    public BudgetService(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

    public Budget createBudget(Budget budget) {
        return budgetRepository.save(budget);
    }

    public List<Budget> getAllBudgets() {
        return budgetRepository.findAll();
    }

    public Optional<Budget> getBudgetById(Long id) {
        return budgetRepository.findById(id);
    }

    public Budget updateBudget(Long id, Budget budget) {

        Budget existingBudget = budgetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Budget not found"));

        existingBudget.setAmount(budget.getAmount());
        existingBudget.setMonth(budget.getMonth());
        existingBudget.setYear(budget.getYear());
        existingBudget.setCategory(budget.getCategory());

        return budgetRepository.save(existingBudget);
    }

    public void deleteBudget(Long id) {

        if (!budgetRepository.existsById(id)) {
            throw new RuntimeException("Budget not found");
        }

        budgetRepository.deleteById(id);
    }
}
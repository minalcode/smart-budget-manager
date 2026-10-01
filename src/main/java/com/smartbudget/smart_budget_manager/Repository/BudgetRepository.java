package com.smartbudget.smart_budget_manager.Repository;

import com.smartbudget.smart_budget_manager.Model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, Long> {
}
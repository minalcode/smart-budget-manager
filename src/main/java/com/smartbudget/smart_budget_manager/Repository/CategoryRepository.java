package com.smartbudget.smart_budget_manager.Repository;

import com.smartbudget.smart_budget_manager.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
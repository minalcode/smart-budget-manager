package com.smartbudget.smart_budget_manager.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BudgetDTO {

    private Double amount;

    private String month;

    private Integer year;

    private Long categoryId;
}
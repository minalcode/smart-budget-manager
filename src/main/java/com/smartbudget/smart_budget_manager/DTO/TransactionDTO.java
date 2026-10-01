package com.smartbudget.smart_budget_manager.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private String title;

    private Double amount;

    private String type;

    private String date;

    private String description;

    private Long categoryId;
}
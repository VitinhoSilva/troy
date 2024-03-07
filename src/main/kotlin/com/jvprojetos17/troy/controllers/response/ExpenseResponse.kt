package com.jvprojetos17.troy.controllers.response

import com.jvprojetos17.troy.domain.entities.Budget
import com.jvprojetos17.troy.domain.entities.Expense
import java.util.UUID

data class ExpenseResponse (
    val id: UUID,
    val description: String,
    val value: Double,
    val budget: BudgetResponse
) {
    companion object {
        fun toResponse(expense: Expense): ExpenseResponse {
            return ExpenseResponse(
                id = expense.id,
                description = expense.description,
                value = expense.value,
                budget = BudgetResponse.toResponse(expense.budget)
            )
        }
    }
}
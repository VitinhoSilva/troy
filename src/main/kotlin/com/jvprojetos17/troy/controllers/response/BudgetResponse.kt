package com.jvprojetos17.troy.controllers.response

import com.jvprojetos17.troy.domain.entities.Budget
import java.util.UUID


data class BudgetResponse (
    val id: UUID,
    val name: String,
    val value: Double,
    val month: String,
    val year: String
) {
    companion object {
        fun toResponse(budget: Budget): BudgetResponse {
            return BudgetResponse(
                id = budget.id,
                name = budget.name,
                value = budget.value,
                month = budget.month,
                year = budget.year
            )
        }
    }
}
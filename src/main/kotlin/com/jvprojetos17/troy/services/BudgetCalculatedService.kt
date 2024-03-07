package com.jvprojetos17.troy.services

import com.jvprojetos17.troy.domain.entities.Budget
import com.jvprojetos17.troy.domain.entities.BudgetedCalculated
import com.jvprojetos17.troy.repository.BudgetCalculatedRepository
import com.jvprojetos17.troy.repository.BudgetRepository
import com.jvprojetos17.troy.repository.ExpenseRepository
import java.time.OffsetDateTime
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class BudgetCalculatedService(
    private val budgetCalculatedRepository: BudgetCalculatedRepository,
    private val expenseRepository: ExpenseRepository,
    private val budgetRepository: BudgetRepository
) {

    fun createBudgetCalculated(budget: Budget) {
        val now = OffsetDateTime.now()
        val budgetCalculated = BudgetedCalculated(
                budget = budget,
                value = budget.value,
                createdAt = now,
                updatedAt = now
            )
        budgetCalculatedRepository.save(budgetCalculated)
    }

    fun updateBudgetCalculated(budgetId: UUID) {
        val budgetPersisted = budgetRepository.findById(budgetId).get()
        val now = OffsetDateTime.now()
        val budgetCalculatedPersisted = budgetCalculatedRepository.findByBudgetId(budgetPersisted.id)
        val budgetValue = budgetPersisted.value
        val sumExpense = expenseRepository.sumExpenseByBudget(budgetPersisted.id)
        val newValueBudgetCalculated = budgetValue - sumExpense

        budgetCalculatedRepository.save(
            budgetCalculatedPersisted.copy(
                value = newValueBudgetCalculated,
                updatedAt = now
            )
        )
    }

}
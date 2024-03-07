package com.jvprojetos17.troy.services

import com.jvprojetos17.troy.controllers.request.ExpenseRequestPatch
import com.jvprojetos17.troy.controllers.request.ExpenseRequestPost
import com.jvprojetos17.troy.controllers.response.ExpenseResponse
import com.jvprojetos17.troy.domain.entities.Expense
import com.jvprojetos17.troy.repository.BudgetRepository
import com.jvprojetos17.troy.repository.ExpenseRepository
import java.time.OffsetDateTime
import java.util.UUID
import org.springframework.stereotype.Service


@Service
class ExpenseService(
    private val budgetRepository: BudgetRepository,
    private val expenseRepository: ExpenseRepository,
    private val budgetCalculatedService: BudgetCalculatedService
) {
    fun createExpense(request: ExpenseRequestPost) {
        val now = OffsetDateTime.now()
        val budgetPersisted = budgetRepository.findById(request.budgetId).get()

        val expense = Expense(
            description = request.description,
            budget = budgetPersisted,
            value = request.value,
            createdAt = now,
            updatedAt = now
        )

        expenseRepository.save(expense)
        budgetCalculatedService.updateBudgetCalculated(budgetPersisted.id)
    }

    fun updateExpense(expenseId: UUID, request: ExpenseRequestPatch) {
        val now = OffsetDateTime.now()
        val expensePersisted = expenseRepository.findById(expenseId).get()
        expenseRepository.save(
            expensePersisted.copy(description = request.description, value = request.value, updatedAt = now)
        )

        budgetCalculatedService.updateBudgetCalculated(expensePersisted.budget.id)
    }

    fun getExpense(expenseId: UUID): ExpenseResponse {
        val expensePersisted = expenseRepository.findById(expenseId).get()
        return ExpenseResponse.toResponse(expensePersisted)
    }

    fun getExpenses(budgetId: UUID): List<ExpenseResponse>? {
        return expenseRepository.findByBudgetId(budgetId)?.map {
            ExpenseResponse.toResponse(it)
        }
    }
}
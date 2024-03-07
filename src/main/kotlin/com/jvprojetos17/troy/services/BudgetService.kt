package com.jvprojetos17.troy.services

import com.jvprojetos17.troy.controllers.request.BudgetRequestPatch
import com.jvprojetos17.troy.controllers.request.BudgetRequestPost
import com.jvprojetos17.troy.controllers.response.BudgetResponse
import com.jvprojetos17.troy.domain.entities.Budget
import com.jvprojetos17.troy.repository.BudgetRepository
import java.time.OffsetDateTime
import java.time.format.TextStyle
import java.util.Locale
import java.util.UUID
import org.springframework.stereotype.Service

@Service
class BudgetService(
    private val budgetRepository: BudgetRepository,
    private val budgetCalculatedService: BudgetCalculatedService
) {
    fun createBudget(budgetRequest: BudgetRequestPost) {
        val now = OffsetDateTime.now()
        val monthName = now.month.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("pt-BR"))
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        val year = now.year.toString()

        if (budgetRequest.value <= 0) {
            throw Exception("The value must be above zero!")
        }

        val budget = Budget(
            name = budgetRequest.name,
            value = budgetRequest.value,
            month = monthName,
            year = year,
            createdAt = now,
            updatedAt = now
        )

        val budgetSaved = budgetRepository.save(budget)
        budgetCalculatedService.createBudgetCalculated(budgetSaved)
    }

    fun updateBudgetValue(budgetId: UUID, request: BudgetRequestPatch) {
        val now = OffsetDateTime.now()
        val budget = budgetRepository.findById(budgetId).get()
        val budgetSaved = budgetRepository.save(
            budget.copy(value = request.value, updatedAt = now)
        )
        budgetCalculatedService.updateBudgetCalculated(budgetSaved.id)
    }

    fun getBudget(budgetId: UUID): BudgetResponse {
        val budgetPersisted = budgetRepository.findById(budgetId).get()
        return BudgetResponse.toResponse(budgetPersisted)
    }

    fun getBudgets(): List<BudgetResponse> {
        return budgetRepository.findAll().map {
            BudgetResponse.toResponse(it)
        }
    }
}
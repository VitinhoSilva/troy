package com.jvprojetos17.troy.repository

import com.jvprojetos17.troy.domain.entities.Expense
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository


@Repository
interface ExpenseRepository : JpaRepository<Expense, UUID> {
    @Query(nativeQuery = true, value = "SELECT SUM(e.value) FROM troy.expense e WHERE budget_id = ?1")
    fun sumExpenseByBudget(budgetId: UUID): Double
}
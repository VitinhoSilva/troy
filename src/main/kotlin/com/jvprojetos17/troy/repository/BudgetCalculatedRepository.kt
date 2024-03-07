package com.jvprojetos17.troy.repository

import com.jvprojetos17.troy.domain.entities.Budget
import com.jvprojetos17.troy.domain.entities.BudgetedCalculated
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BudgetCalculatedRepository : JpaRepository<BudgetedCalculated, UUID> {
    fun findByBudgetId(budgetId: UUID): BudgetedCalculated
}
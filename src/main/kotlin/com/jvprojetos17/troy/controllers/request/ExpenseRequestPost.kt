package com.jvprojetos17.troy.controllers.request

import jakarta.validation.constraints.NotNull
import java.util.UUID

data class ExpenseRequestPost(
    @NotNull(message = "BudgetId required!")
    val budgetId: UUID,
    @NotNull(message = "Description required!")
    val description: String,
    @NotNull(message = "Value required!")
    val value: Double
)

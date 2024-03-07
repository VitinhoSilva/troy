package com.jvprojetos17.troy.controllers.request

import java.util.UUID

data class ExpenseRequestPost(
    val budgetId: UUID,
    val description: String,
    val value: Double
)

package com.jvprojetos17.troy.controllers.request

data class BudgetRequest(
    val name: String,
    val month: Int,
    val year: Int,
    val value: Double
)

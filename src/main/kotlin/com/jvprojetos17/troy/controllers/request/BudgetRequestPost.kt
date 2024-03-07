package com.jvprojetos17.troy.controllers.request

import jakarta.validation.constraints.NotNull

data class BudgetRequestPost(
    @NotNull(message = "Name required!")
    val name: String,
    @NotNull(message = "Value required!")
    val value: Double
)

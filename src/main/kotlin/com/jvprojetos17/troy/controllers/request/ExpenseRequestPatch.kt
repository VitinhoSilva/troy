package com.jvprojetos17.troy.controllers.request

import jakarta.validation.constraints.NotNull


data class ExpenseRequestPatch(
    @NotNull(message = "Description required!")
    val description: String,
    @NotNull(message = "Value required!")
    val value: Double
)

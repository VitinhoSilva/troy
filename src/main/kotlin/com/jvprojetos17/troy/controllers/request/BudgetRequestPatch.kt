package com.jvprojetos17.troy.controllers.request

import jakarta.validation.constraints.NotNull


data class BudgetRequestPatch(
    @NotNull(message = "Value required!")
    val value: Double
)

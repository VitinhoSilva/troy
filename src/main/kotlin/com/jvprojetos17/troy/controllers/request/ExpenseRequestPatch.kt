package com.jvprojetos17.troy.controllers.request


data class ExpenseRequestPatch(
    val description: String,
    val value: Double
)

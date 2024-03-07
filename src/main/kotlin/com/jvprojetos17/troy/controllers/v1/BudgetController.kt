package com.jvprojetos17.troy.controllers.v1

import com.jvprojetos17.troy.controllers.request.BudgetRequest
import com.jvprojetos17.troy.services.BudgetService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/budget")
class BudgetController(
    private val budgetService: BudgetService,
) {

    @PostMapping
    fun createBudget(@RequestBody request: BudgetRequest) {
        budgetService.createBudget(request)
    }
}
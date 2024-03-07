package com.jvprojetos17.troy.controllers.v1

import com.jvprojetos17.troy.controllers.request.BudgetRequestPatch
import com.jvprojetos17.troy.controllers.request.BudgetRequestPost
import com.jvprojetos17.troy.controllers.response.BudgetResponse
import com.jvprojetos17.troy.services.BudgetService
import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/budget")
class BudgetController(
    private val budgetService: BudgetService,
) {

    @GetMapping
    fun hello(): String {
        return "Welcome a back-end application aimed at taking care of the Silva family's budget!"
    }

    @PostMapping
    fun createBudget(@RequestBody request: BudgetRequestPost) {
        budgetService.createBudget(request)
    }

    @PatchMapping("/{budgetId}")
    fun updateBudgetValue(
        @PathVariable budgetId: UUID,
        @RequestBody request: BudgetRequestPatch
    ) {
        budgetService.updateBudgetValue(budgetId, request)
    }

    @GetMapping("/{budgetId}")
    fun getBudget(
        @PathVariable budgetId: UUID,
    ): BudgetResponse {
        return budgetService.getBudget(budgetId)
    }

    @GetMapping("/list")
    fun getBudgets(): List<BudgetResponse> {
        return budgetService.getBudgets()
    }
}
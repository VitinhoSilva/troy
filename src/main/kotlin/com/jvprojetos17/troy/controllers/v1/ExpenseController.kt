package com.jvprojetos17.troy.controllers.v1

import com.jvprojetos17.troy.controllers.request.ExpenseRequestPatch
import com.jvprojetos17.troy.controllers.request.ExpenseRequestPost
import com.jvprojetos17.troy.controllers.response.BudgetResponse
import com.jvprojetos17.troy.controllers.response.ExpenseResponse
import com.jvprojetos17.troy.services.ExpenseService
import java.util.UUID
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/expense/")
class ExpenseController(
    private val expenseService: ExpenseService,
) {
    @PostMapping
    fun createExpense(@RequestBody request: ExpenseRequestPost) {
        expenseService.createExpense(request)
    }

    @GetMapping("{expenseId}")
    fun getExpense(
        @PathVariable expenseId: UUID,
    ): ExpenseResponse {
        return expenseService.getExpense(expenseId)
    }

    @PatchMapping("{expenseId}")
    fun updateExpense(
        @PathVariable expenseId: UUID,
        @RequestBody request: ExpenseRequestPatch
    ) {
        expenseService.updateExpense(expenseId, request)
    }

    @GetMapping("list")
    fun getExpenses(): List<ExpenseResponse> {
        return expenseService.getExpenses()
    }

}
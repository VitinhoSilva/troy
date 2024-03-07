package com.jvprojetos17.troy.repositories

import com.jvprojetos17.troy.domain.entities.Budget
import java.util.UUID
import org.springframework.stereotype.Repository

@Repository
interface BudgetRepository : org.springframework.data.repository.Repository<Budget, UUID> {
}
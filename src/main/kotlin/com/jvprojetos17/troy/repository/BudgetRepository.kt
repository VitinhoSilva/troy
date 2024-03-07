package com.jvprojetos17.troy.repository

import com.jvprojetos17.troy.domain.entities.Budget
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BudgetRepository : JpaRepository<Budget, UUID>
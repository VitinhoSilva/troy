package com.jvprojetos17.troy.domain.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.OffsetDateTime
import java.util.UUID

@Entity
@Table(name = "expense", schema = "troy")
data class Expense (
    @Id
    val id: UUID = UUID.randomUUID(),
    val description: String,

    @ManyToOne
    @JoinColumn(name = "budget_id")
    private val budget: Budget,
    val value: Double,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime,
    val deletedAt: OffsetDateTime?,
)
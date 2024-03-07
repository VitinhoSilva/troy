package com.jvprojetos17.troy.domain.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.OffsetDateTime
import java.util.UUID


@Entity
@Table(name = "budget", schema = "troy")
data class Budget (
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val month: String,
    val year: String,
    val value: Double,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime,
    val deletedAt: OffsetDateTime? = null
)
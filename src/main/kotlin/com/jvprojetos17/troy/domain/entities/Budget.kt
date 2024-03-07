package com.jvprojetos17.troy.domain.entities

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import jakarta.persistence.Table
import java.time.OffsetDateTime
import java.util.UUID


@Entity
@Table(name = "budget", schema = "troy")
data class Budget (
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "month_id", referencedColumnName = "id", nullable = false)
    val month: Month,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "year_id", referencedColumnName = "id", nullable = false)
    val year: Year,
    val value: Double,
    val createdAt: OffsetDateTime,
    val updatedAt: OffsetDateTime,
    val deletedAt: OffsetDateTime?,
)
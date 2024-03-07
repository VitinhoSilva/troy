package com.jvprojetos17.troy.domain.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "month", schema = "troy")
data class Month (
    @Id
    val id: UUID = UUID.randomUUID(),
    val fullName: String
)
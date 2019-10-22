package com.aniketkadam.dogrescuemumbai.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animal_helpline")
data class AnimalHelpLine(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val address: String,
    val phone: List<String>,
    val email: String,
    @Embedded
    val location: Location
)
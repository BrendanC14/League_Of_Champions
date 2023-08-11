package com.example.leagueofchampions.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Competition")
data class Competition(
    @PrimaryKey()
    val id: Int,
    val name: String
    )
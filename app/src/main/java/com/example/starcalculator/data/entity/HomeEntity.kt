package com.example.starcalculator.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "home_data_table")
data class HomeEntity(
    @PrimaryKey val id: Int = 1,
    val stars: List<Int>,
    val targetStar: Int,
    val scrapyardV2: Int,
    val achievementLvl2: Int,
    val masteryLvl17: Int,
    val isMagicBox: Boolean
)

package com.example.starcalculator.domain.model

data class HomeData(
    val id: Int = 1,
    val stars: List<Int>,
    val targetStar: Int,
    val achievementLvl2: Int,
    val masteryLvl17: Int,
    val scrapyardV2: Int,
    val isMagicBox: Boolean
)

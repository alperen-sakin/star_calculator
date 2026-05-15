package com.example.starcalculator.presentation.home.component.parametersSection

import com.example.starcalculator.presentation.home.viewmodel.ParameterType

class ParameterSectionEvents(
    val onAchievementLvl2Change: (String) -> Unit = {},
    val onMasteryLvl17Change: (String) -> Unit = {},
    val onScrapyardV2Change: (String) -> Unit = {},
    val onTargetStarChange: (String) -> Unit = {},
    val onAdjustmentClick: (ParameterType, Boolean) -> Unit
)

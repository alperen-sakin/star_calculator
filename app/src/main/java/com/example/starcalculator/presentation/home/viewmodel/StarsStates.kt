package com.example.starcalculator.presentation.home.viewmodel

import com.example.starcalculator.presentation.home.constants.Constants.MAX_STARS

data class StarsStates(
    val stars: List<String> = List(MAX_STARS) { "" }
)

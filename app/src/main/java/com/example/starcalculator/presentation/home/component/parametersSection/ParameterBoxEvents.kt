package com.example.starcalculator.presentation.home.component.parametersSection

class ParameterBoxEvents(
    val onValueChange: (String) -> Unit,
    val onMinusClick: (String) -> Unit,
    val onPlusClick: (String) -> Unit,
)

class MagicBoxEvents(
    val onMagicBoxClick: (Boolean) -> Unit
)

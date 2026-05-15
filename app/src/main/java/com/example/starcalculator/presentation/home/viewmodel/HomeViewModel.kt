package com.example.starcalculator.presentation.home.viewmodel

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import com.example.starcalculator.presentation.home.constants.Constants.MAX_LEVEL_LENGTH
import com.example.starcalculator.presentation.home.constants.Constants.MAX_STARS
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

enum class ParameterType { ACHIEVEMENT, MASTERY, SCRAPYARD, TARGET }

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    private val _starsStates = MutableStateFlow(StarsStates())
    val starsStates = _starsStates.asStateFlow()

    fun onAllLevelChange(allLevel: String) {
        if (allLevel.length <= MAX_LEVEL_LENGTH && allLevel.isDigitsOnly()) {
            val calculatedTarget = if (allLevel.isNotEmpty()) {
                (allLevel.toInt() + 1).toString()
            } else {
                ""
            }

            _state.update { state ->
                state.copy(
                    allLevel = allLevel,
                    targetStar = calculatedTarget
                )
            }

            _starsStates.update { state ->
                val newStars = List(MAX_STARS) { allLevel }

                state.copy(stars = newStars)
            }
        }
    }

    fun onResetClick() {
        _state.update { state ->
            state.copy(
                allLevel = "",
                achievementLvl2 = "",
                masteryLvl17 = "",
                scrapyardV2 = "",
                targetStar = ""
            )
        }

        _starsStates.update { state ->
            val newStars = List(MAX_STARS) { "" }

            state.copy(stars = newStars)
        }
    }

    fun onStarChange(index: Int, newStarValue: String) {
        if (newStarValue.length <= MAX_LEVEL_LENGTH && newStarValue.all { it.isDigit() }) {
            _starsStates.update { currentState ->
                val newStars = currentState.stars.toMutableList()

                newStars[index] = newStarValue
                currentState.copy(stars = newStars)
            }
        }
    }

    fun onAchievementLvl2Change(level: String) {
        if (level.length <= MAX_LEVEL_LENGTH && level.isDigitsOnly()) {
            _state.update { state ->
                state.copy(achievementLvl2 = level)
            }
        }
    }

    fun onMasteryLvl17Change(level: String) {
        if (level.length <= MAX_LEVEL_LENGTH && level.isDigitsOnly()) {
            _state.update { state ->
                state.copy(masteryLvl17 = level)
            }
        }
    }

    fun onScrapyardV2Change(level: String) {
        if (level.length <= MAX_LEVEL_LENGTH && level.isDigitsOnly()) {
            _state.update { state ->
                state.copy(scrapyardV2 = level)
            }
        }
    }

    fun onTargetStarChange(level: String) {
        if (level.length <= MAX_LEVEL_LENGTH && level.isDigitsOnly()) {
            _state.update { state ->
                state.copy(targetStar = level)
            }
        }
    }

    fun onAdjustmentClick(type: ParameterType, isIncrement: Boolean) {
        _state.update { state ->
            val currentValueStr = when (type) {
                ParameterType.ACHIEVEMENT -> state.achievementLvl2
                ParameterType.MASTERY -> state.masteryLvl17
                ParameterType.SCRAPYARD -> state.scrapyardV2
                ParameterType.TARGET -> state.targetStar
            }

            val currentValue = currentValueStr.toIntOrNull() ?: 0
            val newValue =
                if (isIncrement) currentValue + 1 else (currentValue - 1).coerceAtLeast(0)

            when (type) {
                ParameterType.ACHIEVEMENT -> state.copy(achievementLvl2 = newValue.toString())
                ParameterType.MASTERY -> state.copy(masteryLvl17 = newValue.toString())
                ParameterType.SCRAPYARD -> state.copy(scrapyardV2 = newValue.toString())
                ParameterType.TARGET -> state.copy(targetStar = newValue.toString())
            }
        }
    }
}

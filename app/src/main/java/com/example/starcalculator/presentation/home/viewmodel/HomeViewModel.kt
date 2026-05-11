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

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    private val _starsStates = MutableStateFlow(StarsStates())
    val starsStates = _starsStates.asStateFlow()

    fun onAllLevelChange(allLevel: String) {
        if (allLevel.length <= MAX_LEVEL_LENGTH && allLevel.isDigitsOnly()) {
            _state.update { state ->
                state.copy(
                    allLevel = allLevel,
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
}

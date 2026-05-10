package com.example.starcalculator.presentation.home.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state = _state.asStateFlow()

    fun onAllLevelChange(allLevel: String) {
        _state.update { state ->
            state.copy(
                allLevel = allLevel,
            )
        }
    }

    fun onResetClick() {
        _state.update { state ->
            state.copy(
                allLevel = "",
            )
        }
    }
}

package com.example.starcalculator.presentation.home

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.starcalculator.presentation.home.component.CustomTopAppBar
import com.example.starcalculator.presentation.home.component.SetAllStarsBox
import com.example.starcalculator.presentation.home.viewmodel.HomeViewModel
import com.example.starcalculator.presentation.ui.theme.SlateGray900

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    val focusManager = LocalFocusManager.current

    Scaffold(
        modifier = Modifier
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            },
        topBar = {
            Column {
                CustomTopAppBar(
                    onResetClick = { viewModel.onResetClick() }
                )
                HorizontalDivider(
                    thickness = 2.dp,
                    color = SlateGray900
                )
            }
        }
    ) {
        Column(
            modifier = modifier
                .padding(paddingValues = it)
                .padding(vertical = 16.dp, horizontal = 8.dp)
        ) {
            SetAllStarsBox(
                onAllLevelChange = { allLevel ->
                    viewModel.onAllLevelChange(allLevel)
                },
                allLevel = state.value.allLevel,
            )
        }
    }
}

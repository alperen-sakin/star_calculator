package com.example.starcalculator.presentation.home

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FabPosition
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.starcalculator.presentation.home.component.CustomFloatingButton
import com.example.starcalculator.presentation.home.component.CustomTopAppBar
import com.example.starcalculator.presentation.home.component.SetAllStarsBox
import com.example.starcalculator.presentation.home.component.parametersSection.ParameterSectionEvents
import com.example.starcalculator.presentation.home.component.parametersSection.ParameterSectionState
import com.example.starcalculator.presentation.home.component.parametersSection.ParametersSection
import com.example.starcalculator.presentation.home.component.resultsSection.ResultSection
import com.example.starcalculator.presentation.home.component.resultsSection.ResultSectionState
import com.example.starcalculator.presentation.home.component.starsSection.StarsSection
import com.example.starcalculator.presentation.home.viewmodel.HomeState
import com.example.starcalculator.presentation.home.viewmodel.HomeViewModel
import com.example.starcalculator.presentation.home.viewmodel.StarsStates
import com.example.starcalculator.presentation.ui.theme.SlateGray900
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()
    val starsStates = viewModel.starsStates.collectAsStateWithLifecycle()

    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()

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
        },
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            CustomFloatingButton(
                onCalculateClick = {
                    focusManager.clearFocus()
                    viewModel.onCalculateClick()

                    coroutineScope.launch {
                        scrollState.animateScrollTo(scrollState.maxValue)
                    }
                }
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(paddingValues = it)
                .padding(horizontal = 8.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TopSection(viewModel, state, starsStates)

            BottomSection(state, viewModel)
        }
    }
}

@Composable
private fun BottomSection(
    state: State<HomeState>,
    viewModel: HomeViewModel
) {
    ParametersSection(
        state = ParameterSectionState(
            achievementLvl2 = state.value.achievementLvl2,
            masteryLvl17 = state.value.masteryLvl17,
            scrapyardV2 = state.value.scrapyardV2,
            targetStar = state.value.targetStar,
        ),

        events = ParameterSectionEvents(
            onAchievementLvl2Change = viewModel::onAchievementLvl2Change,
            onMasteryLvl17Change = viewModel::onMasteryLvl17Change,
            onScrapyardV2Change = viewModel::onScrapyardV2Change,
            onTargetStarChange = viewModel::onTargetStarChange,
            onAdjustmentClick = viewModel::onAdjustmentClick

        )

    )

    ResultSection(
        state = ResultSectionState(
            costMagnet = state.value.costMagnet,
            costGoldenScrap = state.value.costGoldenScrap,
            costFragment = state.value.costFragment
        )
    )
}

@Composable
private fun TopSection(
    viewModel: HomeViewModel,
    state: State<HomeState>,
    starsStates: State<StarsStates>
) {
    SetAllStarsBox(
        onAllLevelChange = { allLevel ->
            viewModel.onAllLevelChange(allLevel)
        },
        allLevel = state.value.allLevel,
        modifier = Modifier.padding(top = 16.dp)
    )

    StarsSection(
        starsStates = starsStates.value,
        onStarChange = { index, newStarValue ->
            viewModel.onStarChange(
                index,
                newStarValue
            )
        }

    )
}

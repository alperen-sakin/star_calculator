package com.example.starcalculator.presentation.home.component.parametersSection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.starcalculator.presentation.home.viewmodel.ParameterType
import com.example.starcalculator.presentation.ui.theme.SlateGray800
import com.example.starcalculator.presentation.ui.theme.SlateGray900

private data class ParameterItem(
    val title: String,
    val type: ParameterType,
    val value: String,
    val onValueChange: (String) -> Unit,
    val isHighlight: Boolean = false
)

@Composable
fun ParametersSection(
    modifier: Modifier = Modifier,
    state: ParameterSectionState,
    events: ParameterSectionEvents,
) {
    val items = listOf(
        ParameterItem(
            "Achievement LVL 2",
            ParameterType.ACHIEVEMENT,
            state.achievementLvl2,
            events.onAchievementLvl2Change
        ),
        ParameterItem(
            "Mastery LVL 17",
            ParameterType.MASTERY,
            state.masteryLvl17,
            events.onMasteryLvl17Change
        ),
        ParameterItem(
            "Scrapyard V2",
            ParameterType.SCRAPYARD,
            state.scrapyardV2,
            events.onScrapyardV2Change
        ),
        ParameterItem(
            "Target Star",
            ParameterType.TARGET,
            state.targetStar,
            events.onTargetStarChange,
            isHighlight = true
        )
    )

    Column(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = 2.dp,
                color = SlateGray800,
                shape = MaterialTheme.shapes.medium
            )
            .fillMaxWidth()
            .background(color = SlateGray900),

    ) {
        items.forEachIndexed { index, item ->
            ParameterBox(
                state = ParameterBoxState(
                    title = item.title,
                    value = item.value,
                    isHighlight = item.isHighlight
                ),
                events = ParameterBoxEvents(
                    onValueChange = item.onValueChange,
                    onMinusClick = { events.onAdjustmentClick(item.type, false) },
                    onPlusClick = { events.onAdjustmentClick(item.type, true) }
                )
            )

            if (index < items.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = SlateGray800
                )
            }
        }
    }
}

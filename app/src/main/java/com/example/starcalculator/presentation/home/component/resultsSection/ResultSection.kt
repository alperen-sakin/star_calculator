package com.example.starcalculator.presentation.home.component.resultsSection

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.starcalculator.R

private data class ResultItem(
    val title: String,
    val value: String,
    val icon: Painter
)

@Composable
fun ResultSection(
    modifier: Modifier = Modifier,
    state: ResultSectionState
) {
    val items = listOf(
        ResultItem(
            title = "MAGNET",
            value = state.costMagnet,
            icon = painterResource(id = R.drawable.magnet_icon)
        ),
        ResultItem(
            title = "GOLDEN SCRAP",
            value = state.costGoldenScrap,
            icon = painterResource(id = R.drawable.golden_scrap_icon)
        ),
        ResultItem(
            title = "FRAGMENT",
            value = state.costFragment,
            icon = painterResource(id = R.drawable.fragment_icon)

        ),
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items.forEachIndexed { index, item ->
            ResultBox(
                icon = item.icon,
                title = item.title,
                value = item.value
            )
        }
    }
}

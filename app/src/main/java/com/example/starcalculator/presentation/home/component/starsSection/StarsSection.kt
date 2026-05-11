package com.example.starcalculator.presentation.home.component.starsSection

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.starcalculator.presentation.home.constants.Constants.ROWS
import com.example.starcalculator.presentation.home.viewmodel.StarsStates
import com.example.starcalculator.presentation.ui.theme.SlateGray800
import com.example.starcalculator.presentation.ui.theme.SlateGray900

@Composable
fun StarsSection(
    starsStates: StarsStates,
    onStarChange: (Int, String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = SlateGray900)
            .border(
                width = 2.dp,
                color = SlateGray800,
                shape = MaterialTheme.shapes.medium
            )
            .padding(all = 16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var currentIndex = 0

        ROWS.forEach { count ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterHorizontally)
            ) {
                repeat(count) {
                    val index = currentIndex
                    StarTextField(
                        modifier = Modifier.width(90.dp),
                        starValue = starsStates.stars[index],
                        onStarChange = { newStarValue -> onStarChange(index, newStarValue) }
                    )
                    currentIndex++
                }
            }
        }
    }
}

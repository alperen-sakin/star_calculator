package com.example.starcalculator.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.starcalculator.presentation.home.component.CustomTopAppBar
import com.example.starcalculator.presentation.ui.theme.SlateGray900

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            Column {
                CustomTopAppBar(
                    onResetClick = {}
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
        ) { }
    }
}

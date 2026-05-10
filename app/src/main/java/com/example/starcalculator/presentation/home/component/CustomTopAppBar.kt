package com.example.starcalculator.presentation.home.component

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.starcalculator.presentation.ui.theme.SlateGray400
import com.example.starcalculator.presentation.ui.theme.SlateGray950
import com.example.starcalculator.presentation.ui.theme.TitleGradient

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    onResetClick: () -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SlateGray950,
            titleContentColor = Color.Transparent,

        ),
        title = {
            Text(
                text = "Star Calculator",
                style = TextStyle(
                    brush = Brush.linearGradient(TitleGradient)
                ),
                fontWeight = FontWeight.Black,
                fontSize = 20.sp,
            )
        },
        actions = {
            IconButton(
                onClick = onResetClick,
                interactionSource = interactionSource,
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = null,
                    tint = if (isPressed) Color.White else SlateGray400,

                )
            }
        },

    )
}

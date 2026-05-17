package com.example.starcalculator.presentation.home.component.parametersSection

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starcalculator.presentation.ui.theme.Emerald400
import com.example.starcalculator.presentation.ui.theme.SlateGray300

@Composable
fun MagicBox(
    modifier: Modifier = Modifier,

    state: MagicBoxState,
    events: MagicBoxEvents,

) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.Transparent)
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = "Use Black Magic (Experimental):",
            fontSize = 14.sp,
            color = SlateGray300,
            fontWeight = FontWeight.Medium

        )

        Switch(
            checked = state.isMagicBox,
            onCheckedChange = {
                events.onMagicBoxClick(it)
            },
            thumbContent = if (state.isMagicBox) {
                {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = null,
                        tint = Emerald400
                    )
                }
            } else { null },
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = Emerald400,
                uncheckedThumbColor = Color.White,
                uncheckedTrackColor = SlateGray300

            )
        )
    }
}

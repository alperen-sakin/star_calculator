package com.example.starcalculator.presentation.home.component.parametersSection

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starcalculator.presentation.home.constants.Constants.FIFTY_PERCENT
import com.example.starcalculator.presentation.home.constants.Constants.FIVE_PERCENT
import com.example.starcalculator.presentation.ui.theme.Emerald500
import com.example.starcalculator.presentation.ui.theme.SlateGray300
import com.example.starcalculator.presentation.ui.theme.SlateGray400
import com.example.starcalculator.presentation.ui.theme.SlateGray600
import com.example.starcalculator.presentation.ui.theme.SlateGray800
import com.example.starcalculator.presentation.ui.theme.SlateGray950
import com.example.starcalculator.presentation.ui.theme.Yellow400
import com.example.starcalculator.presentation.ui.theme.Yellow500

@Composable
fun ParameterBox(
    modifier: Modifier = Modifier,

    state: ParameterBoxState,
    events: ParameterBoxEvents,

) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = if (state.isHighlight) Yellow500.copy(FIVE_PERCENT) else Color.Transparent)
            .padding(all = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Text(
            modifier = Modifier.weight(1f),
            text = state.title,
            fontSize = 14.sp,
            color = if (state.isHighlight) Yellow400 else SlateGray300,
            fontWeight = if (state.isHighlight) FontWeight.Bold else FontWeight.Medium

        )

        InputSection(
            modifier = Modifier.weight(1f),
            events = events,
            state = state
        )
    }
}

@Composable
fun InputSection(
    modifier: Modifier = Modifier,
    state: ParameterBoxState,
    events: ParameterBoxEvents,
) {
    var isFocused by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    val borderColor = when {
        state.isHighlight && isFocused -> Yellow500
        state.isHighlight -> Yellow500.copy(FIFTY_PERCENT)
        isFocused -> Emerald500
        else -> SlateGray800
    }
    val animatedBorderColor by animateColorAsState(
        targetValue = borderColor,
        label = "BorderColorAnimation"
    )

    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.large)
            .background(SlateGray950)
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .border(
                width = 2.dp,
                color = animatedBorderColor,
                shape = MaterialTheme.shapes.large
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        IconButtons(focusManager, events.onMinusClick, state, Icons.Default.Remove)

        Input(state, events)

        IconButtons(focusManager, events.onPlusClick, state, image = Icons.Default.Add)
    }
}

@Composable
private fun IconButtons(
    focusManager: FocusManager,
    events: (String) -> Unit,
    state: ParameterBoxState,
    image: ImageVector
) {
    IconButton(
        onClick = {
            focusManager.clearFocus()
            events(state.value)
        }
    ) {
        Icon(
            imageVector = image,
            contentDescription = null,
            tint = SlateGray400,
            modifier = Modifier
                .height(16.dp)
                .width(16.dp)
        )
    }
}

@Composable
private fun RowScope.Input(
    state: ParameterBoxState,
    events: ParameterBoxEvents,
) {
    BasicTextField(
        modifier = Modifier
            .weight(1f),
        value = state.value,
        onValueChange = {
            events.onValueChange(it)
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        textStyle = TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
        ),
        decorationBox = { innerTextField ->
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (state.value.isEmpty()) {
                    Text(
                        text = "LVL",
                        color = SlateGray600,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                innerTextField()
            }
        }

    )
}

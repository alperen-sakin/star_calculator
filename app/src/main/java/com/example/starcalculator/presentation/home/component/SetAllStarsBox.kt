package com.example.starcalculator.presentation.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starcalculator.presentation.ui.theme.SlateGray300
import com.example.starcalculator.presentation.ui.theme.SlateGray600
import com.example.starcalculator.presentation.ui.theme.SlateGray700
import com.example.starcalculator.presentation.ui.theme.SlateGray800
import com.example.starcalculator.presentation.ui.theme.SlateGray900
import com.example.starcalculator.presentation.ui.theme.SlateGray950
import com.example.starcalculator.presentation.ui.theme.Yellow400
import com.example.starcalculator.presentation.ui.theme.Yellow500

@Composable
fun SetAllStarsBox(
    onAllLevelChange: (String) -> Unit = {},
    allLevel: String,
) {
    Row(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = 2.dp,
                color = SlateGray800,
                shape = MaterialTheme.shapes.medium
            )
            .background(
                color = SlateGray900.copy(alpha = 0.8f),
            )
            .padding(16.dp)
            .fillMaxWidth(),

        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text(
            text = "Set ALL Star",
            color = SlateGray300,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold
        )

        SetAllStarInput(allLevel, onAllLevelChange)
    }
}

@Composable
private fun SetAllStarInput(allLevel: String, onAllLevelChange: (String) -> Unit) {
    OutlinedTextField(
        modifier = Modifier
            .width(96.dp),
        value = allLevel,
        onValueChange = {
            onAllLevelChange(it)
        },
        shape = MaterialTheme.shapes.medium,
        placeholder = {
            Text(
                text = "Level",
                color = SlateGray600,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = SlateGray950,
            focusedContainerColor = SlateGray950,
            unfocusedBorderColor = SlateGray700,
            focusedBorderColor = Yellow500,
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
        textStyle = TextStyle(
            color = Yellow400,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            lineHeight = 0.sp
        ),

    )
}

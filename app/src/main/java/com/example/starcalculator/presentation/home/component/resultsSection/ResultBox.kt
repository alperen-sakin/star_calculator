package com.example.starcalculator.presentation.home.component.resultsSection

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starcalculator.presentation.ui.theme.SlateGray400
import com.example.starcalculator.presentation.ui.theme.SlateGray800
import com.example.starcalculator.presentation.ui.theme.SlateGray900
import com.example.starcalculator.presentation.ui.theme.SlateGray950

@Composable
fun ResultBox(
    modifier: Modifier = Modifier,
    icon: Painter,
    title: String,
    value: String
) {
    Row(
        modifier = modifier
            .clip(MaterialTheme.shapes.medium)
            .border(
                width = 2.dp,
                color = SlateGray800,
                shape = MaterialTheme.shapes.medium
            )
            .fillMaxWidth()
            .background(color = SlateGray900.copy(alpha = 0.8f))
            .padding(all = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween

    ) {
        Box(
            modifier = Modifier
                .clip(shape = MaterialTheme.shapes.medium)
                .background(SlateGray950)
                .padding(8.dp),
            contentAlignment = Alignment.Center

        ) {
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .width(20.dp)
                    .height(20.dp)
            )
        }

        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = SlateGray400,
            modifier = Modifier.padding(start = 8.dp)
        )

        Text(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Black,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End

        )
    }
}

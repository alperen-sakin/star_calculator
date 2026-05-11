package com.example.starcalculator.presentation.home.component.starsSection

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.starcalculator.R
import com.example.starcalculator.presentation.ui.theme.Amber600

@Composable
fun StarTextField(
    modifier: Modifier = Modifier,
    starValue: String,
    onStarChange: (String) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.star_icon),
            contentDescription = null,
            modifier = modifier
        )

        TextField(
            value = starValue,
            onValueChange = {
                onStarChange(it)
            },
            modifier = modifier,
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Amber600,
                unfocusedIndicatorColor = Color.Transparent,

            ),
            placeholder = {
                Text(
                    text = "0",
                    color = Amber600,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            },

            textStyle = TextStyle(
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            ),

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

        )
    }
}

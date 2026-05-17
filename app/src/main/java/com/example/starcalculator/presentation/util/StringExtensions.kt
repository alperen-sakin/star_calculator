package com.example.starcalculator.presentation.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale

fun String.toFormattedNumber(): String {
    val number = this.toLongOrNull() ?: return "0"

    val symbols = DecimalFormatSymbols(Locale.US).apply {
        groupingSeparator = '.'
    }

    val formatter = DecimalFormat("#,###", symbols)
    return formatter.format(number)
}

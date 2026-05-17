package com.example.starcalculator.presentation.util

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.Locale
import kotlin.math.floor
import kotlin.math.log10
import kotlin.math.pow

fun String.toFormattedNumber(): String {
    val number = this.toLongOrNull() ?: return "0"

    val symbols = DecimalFormatSymbols(Locale.US).apply {
        groupingSeparator = '.'
    }

    val formatter = DecimalFormat("#,###", symbols)
    return formatter.format(number)
}

@Suppress("MagicNumber", "ReturnCount")
fun String.toAbstractNotation(): String {
    val number = this.toDoubleOrNull() ?: return "0"
    if (number < 1_000_000) {
        val symbols = DecimalFormatSymbols(Locale.US).apply { groupingSeparator = '.' }
        return DecimalFormat("#,###", symbols).format(number.toLong())
    }

    val exponent = floor(log10(number)).toInt()

    val index = (exponent / 3) - 1

    val mantissa = number / 10.0.pow((exponent / 3) * 3)

    val symbols = DecimalFormatSymbols(Locale.US).apply { decimalSeparator = '.' }
    val formatter = DecimalFormat("#.##", symbols)
    val formattedMantissa = formatter.format(mantissa)

    val letterNotation = convertIndexToLetter(index)

    return "$formattedMantissa $letterNotation"
}

@Suppress("MagicNumber", "ReturnCount")
private fun convertIndexToLetter(index: Int): String {
    if (index <= 0) return ""
    val remainder = (index - 1) % 26 + 1
    val currentLetter = (96 + remainder).toChar().toString()
    return convertIndexToLetter((index - remainder) / 26) + currentLetter
}

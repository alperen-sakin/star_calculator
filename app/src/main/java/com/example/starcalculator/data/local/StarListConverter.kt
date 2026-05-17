package com.example.starcalculator.data.local

import androidx.room.TypeConverter

class StarListConverter {

    @TypeConverter
    fun fromString(value: String): List<Int> {
        if (value.isEmpty()) return emptyList()
        return value.split(",").map { it.toInt() }
    }

    @TypeConverter
    fun fromList(list: List<Int>): String {
        return list.joinToString(separator = ",")
    }
}

package com.example.starcalculator.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.starcalculator.data.entity.HomeEntity

@Database(entities = [HomeEntity::class], version = 1, exportSchema = false)
@TypeConverters(StarListConverter::class)
abstract class HomeDataBase : RoomDatabase() {
    abstract val homeDao: HomeDao
}

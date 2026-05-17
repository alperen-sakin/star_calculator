package com.example.starcalculator.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.starcalculator.data.entity.HomeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHomeData(homeEntity: HomeEntity)

    @Query("SELECT * FROM home_data_table WHERE id = 1")
    fun getHomeData(): Flow<HomeEntity?>
}

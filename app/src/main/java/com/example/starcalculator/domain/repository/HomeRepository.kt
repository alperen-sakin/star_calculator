package com.example.starcalculator.domain.repository

import com.example.starcalculator.domain.model.HomeData
import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    fun getHomeData(): Flow<HomeData?>

    suspend fun saveHomeData(homeData: HomeData)
}

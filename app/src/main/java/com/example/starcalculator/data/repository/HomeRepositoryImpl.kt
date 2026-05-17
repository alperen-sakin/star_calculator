package com.example.starcalculator.data.repository

import com.example.starcalculator.data.local.HomeDao
import com.example.starcalculator.data.mappers.toDomain
import com.example.starcalculator.data.mappers.toEntity
import com.example.starcalculator.domain.model.HomeData
import com.example.starcalculator.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class HomeRepositoryImpl(
    private val homeDao: HomeDao
) : HomeRepository {

    override fun getHomeData(): Flow<HomeData?> {
        return homeDao.getHomeData().map { entity ->
            entity?.toDomain()
        }
    }

    override suspend fun saveHomeData(homeData: HomeData) {
        homeDao.insertHomeData(homeData.toEntity())
    }
}

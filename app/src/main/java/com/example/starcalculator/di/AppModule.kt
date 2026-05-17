package com.example.starcalculator.di

import android.content.Context
import androidx.room.Room
import com.example.starcalculator.data.local.HomeDao
import com.example.starcalculator.data.local.HomeDataBase
import com.example.starcalculator.data.repository.HomeRepositoryImpl
import com.example.starcalculator.domain.repository.HomeRepository
import com.example.starcalculator.domain.useCase.CalculateTotalCostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlin.jvm.java

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCalculateTotalCostUseCase(): CalculateTotalCostUseCase {
        return CalculateTotalCostUseCase()
    }

    @Provides
    @Singleton
    fun provideHomeDatabase(
        @ApplicationContext context: Context
    ): HomeDataBase {
        return Room.databaseBuilder(
            context,
            HomeDataBase::class.java,
            "star_calculator_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideHomeDao(database: HomeDataBase): HomeDao {
        return database.homeDao
    }

    @Provides
    @Singleton
    fun provideHomeRepository(homeDao: HomeDao): HomeRepository {
        return HomeRepositoryImpl(homeDao)
    }
}

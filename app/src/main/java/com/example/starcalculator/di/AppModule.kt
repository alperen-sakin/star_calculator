package com.example.starcalculator.di

import com.example.starcalculator.domain.useCase.CalculateTotalCostUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCalculateTotalCostUseCase(): CalculateTotalCostUseCase {
        return CalculateTotalCostUseCase()
    }
}

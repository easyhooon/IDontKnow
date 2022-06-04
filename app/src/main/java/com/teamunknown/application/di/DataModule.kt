package com.teamunknown.application.di

import com.teamunknown.application.repository.CheckListLocalDataSource
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.repository.TravelLocalDataSource
import com.teamunknown.application.repository.checklist.CheckListLocalDataSourceImpl
import com.teamunknown.application.repository.travel.TravelLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Singleton
    @Provides
    fun provideTravelLocalDataSource(travelDatabase: TravelDatabase): TravelLocalDataSource = TravelLocalDataSourceImpl(travelDatabase)

    @Singleton
    @Provides
    fun provideCheckListLocalDataSource(travelDatabase: TravelDatabase): CheckListLocalDataSource = CheckListLocalDataSourceImpl(travelDatabase)
}
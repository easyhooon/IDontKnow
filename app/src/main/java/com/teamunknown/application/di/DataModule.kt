package com.teamunknown.application.di

import com.teamunknown.application.repository.CheckListLocalDataSource
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.repository.travel.CheckListLocalDataSourceImpl
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
    internal fun provideCheckListLocalDataSource(travelDatabase: TravelDatabase)
    : CheckListLocalDataSource = CheckListLocalDataSourceImpl(travelDatabase)
}
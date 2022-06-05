package com.teamunknown.application.di

import com.teamunknown.application.repository.CheckListLocalDataSource
import com.teamunknown.application.repository.DiaryLocalDataSource
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.repository.TravelLocalDataSource
import com.teamunknown.application.repository.checklist.CheckListLocalDataSourceImpl
import com.teamunknown.application.repository.diary.DiaryLocalDataSourceImpl
import com.teamunknown.application.repository.checklist.CheckListRepositoryImpl
import com.teamunknown.application.repository.travel.TravelLocalDataSourceImpl
import com.teamunknown.application.repository.travel.TravelRepositoryImpl
import com.teamunknown.application.usecase.checklist.CheckListRepository
import com.teamunknown.application.usecase.travel.TravelRepository
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

    @Singleton
    @Provides
    fun provideDiaryLocalDataSource(travelDatabase: TravelDatabase) : DiaryLocalDataSource = DiaryLocalDataSourceImpl(travelDatabase)

    @Singleton
    @Provides
    fun provideTravelRecordRepository(travelLocalDataSource: TravelLocalDataSource): TravelRepository = TravelRepositoryImpl(travelLocalDataSource)

    @Singleton
    @Provides
    fun provideTravelCheckListRepository(travelCheckListLocalDataSource: CheckListLocalDataSource): CheckListRepository = CheckListRepositoryImpl(travelCheckListLocalDataSource)
}
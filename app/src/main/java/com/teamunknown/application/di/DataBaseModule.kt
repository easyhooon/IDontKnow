package com.teamunknown.application.di

import android.content.Context
import com.teamunknown.application.repository.TravelDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun providesTravelDatabase(
        @ApplicationContext context: Context
    ): TravelDatabase = TravelDatabase.buildDatabase(context)
}
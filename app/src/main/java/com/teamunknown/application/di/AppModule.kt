package com.teamunknown.application.di

import android.content.Context
import com.teamunknown.application.utils.NetworkState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {

    @Provides
    fun providesNetworkStateManager(
        @ApplicationContext context: Context
    ): NetworkState = NetworkState(context)
}
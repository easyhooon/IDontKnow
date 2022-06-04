package com.teamunknown.application.repository

import com.teamunknown.application.model.Travel
import kotlinx.coroutines.flow.Flow

interface TravelLocalDataSource {

    fun getTravels(travelId: Long?) : Flow<Result<List<Travel>>>

    suspend fun insertTravel(travel : Travel)

    suspend fun clearTravel(travel: Travel)

    suspend fun clearTravel()
}
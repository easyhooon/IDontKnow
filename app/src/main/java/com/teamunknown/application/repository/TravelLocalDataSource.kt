package com.teamunknown.application.repository

import com.teamunknown.application.model.Travel
import kotlinx.coroutines.flow.Flow
import com.teamunknown.application.utils.Result

interface TravelLocalDataSource {

    fun getTravels() : Flow<Result<List<Travel>>>

    suspend fun insertTravel(travel : Travel)

    suspend fun clearTravel(travel: List<Travel>)

    suspend fun clearTravel()
}
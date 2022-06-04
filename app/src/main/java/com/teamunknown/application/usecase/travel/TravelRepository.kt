package com.teamunknown.application.usecase.travel

import com.teamunknown.application.model.Travel
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow

interface TravelRepository {

    fun getTravelRecords() : Flow<Result<List<Travel>>>

    suspend fun setTravelRecords(travel: Travel)

    suspend fun clearTravelRecords()
}
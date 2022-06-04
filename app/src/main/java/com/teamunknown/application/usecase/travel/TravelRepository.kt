package com.teamunknown.application.usecase.travel

import com.teamunknown.application.model.Travel
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow

interface TravelRepository {

    fun getTravelRecords(travelId: Long?) : Flow<Result<List<Travel>>>

    suspend fun setTravelRecords(travel: Travel) : Result<Unit>

    suspend fun clearTravelRecords() : Result<Unit>
}
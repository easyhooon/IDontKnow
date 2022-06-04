package com.teamunknown.application.repository.travel

import com.teamunknown.application.model.Travel
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.repository.TravelLocalDataSource
import kotlinx.coroutines.flow.Flow

class TravelLocalDataSourceImpl(
    private val travelDatabase: TravelDatabase
) : TravelLocalDataSource {

    override fun getTravels(travelId: Long?): Flow<Result<List<Travel>>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertTravel(travel: Travel) {
        TODO("Not yet implemented")
    }

    override suspend fun clearTravel(travel: Travel) {
        TODO("Not yet implemented")
    }

    override suspend fun clearTravel() {
        TODO("Not yet implemented")
    }
}
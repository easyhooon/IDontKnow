package com.teamunknown.application.repository.travel

import com.teamunknown.application.model.Travel
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.repository.TravelLocalDataSource
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


class TravelLocalDataSourceImpl(
    private val travelDatabase: TravelDatabase
) : TravelLocalDataSource {

    override fun getTravels() : Flow<Result<List<Travel>>> = travelDatabase.travelDao().getTravels().map { Result.Success(it) }

    override suspend fun insertTravel(travel: Travel) {
        travelDatabase.travelDao().insertTravel(travel)
    }

    override suspend fun clearTravel(travel: List<Travel>) {
        travelDatabase.travelDao().clearTravel(travel)
    }

    override suspend fun clearTravel() {
        travelDatabase.travelDao().clearTravel()
    }
}
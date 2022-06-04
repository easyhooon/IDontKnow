package com.teamunknown.application.repository.travel

import com.teamunknown.application.model.Travel
import com.teamunknown.application.repository.TravelLocalDataSource
import com.teamunknown.application.usecase.travel.TravelRepository
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TravelRepositoryImpl(
    private val travelLocalDataSource: TravelLocalDataSource
) : TravelRepository {

    override fun getTravelRecords() : Flow<Result<List<Travel>>> = flow {
        travelLocalDataSource.getTravels()
    }

    override suspend fun setTravelRecords(travel: Travel) {
        travelLocalDataSource.insertTravel(travel)
    }

    override suspend fun clearTravelRecords() {
        travelLocalDataSource.clearTravel()
    }
}
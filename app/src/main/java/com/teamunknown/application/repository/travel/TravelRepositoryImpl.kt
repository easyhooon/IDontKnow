package com.teamunknown.application.repository.travel

import com.teamunknown.application.model.Travel
import com.teamunknown.application.repository.TravelLocalDataSource
import com.teamunknown.application.usecase.travel.TravelRepository
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import timber.log.Timber

class TravelRepositoryImpl(
    private val travelLocalDataSource: TravelLocalDataSource
) : TravelRepository {

    override fun getTravelRecords(travelId: Long?): Flow<Result<List<Travel>>> = flow {
        travelLocalDataSource.getTravels(travelId)
    }

    override suspend fun setTravelRecords(travel: Travel): Result<Unit> {
        return Result.Success(travelLocalDataSource.insertTravel(travel))
    }

    override suspend fun clearTravelRecords(): Result<Unit> {
        return Result.Success(travelLocalDataSource.clearTravel())
    }
}
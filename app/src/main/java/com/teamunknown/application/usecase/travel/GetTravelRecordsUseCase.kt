package com.teamunknown.application.usecase.travel

import com.teamunknown.application.di.IoDispatcher
import com.teamunknown.application.model.Travel
import com.teamunknown.application.utils.FlowUseCase
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetTravelRecordsUseCase @Inject constructor(
    private val travelRepository: TravelRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<Travel>>(ioDispatcher) {

    override fun execute(params: Unit): Flow<Result<List<Travel>>> {
        return travelRepository.getTravelRecords()
    }
}
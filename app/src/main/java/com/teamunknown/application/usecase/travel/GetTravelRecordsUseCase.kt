package com.teamunknown.application.usecase.travel

import com.teamunknown.application.di.IoDispatcher
import com.teamunknown.application.model.Travel
import com.teamunknown.application.utils.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import javax.inject.Inject
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.flowOf

open class GetTravelRecordsUseCase @Inject constructor(
    private val travelRepository: TravelRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<Unit, List<Travel>>(ioDispatcher) {

    override fun execute(params: Unit): Flow<Result<List<Travel>>> {
        return travelRepository.getTravelRecords().flatMapConcat { travelList ->
            when (travelList) {
                is Result.Loading -> flowOf(travelList)
                is Result.Success -> flowOf(Result.Success(travelList.data))
                is Result.Error -> flowOf(travelList)
            }
        }
    }
}
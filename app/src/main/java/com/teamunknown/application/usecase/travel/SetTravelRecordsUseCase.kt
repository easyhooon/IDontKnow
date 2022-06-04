package com.teamunknown.application.usecase.travel

import com.teamunknown.application.di.IoDispatcher
import com.teamunknown.application.model.Travel
import com.teamunknown.application.utils.FlowUseCase
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class SetTravelRecordsUseCase @Inject constructor(
    private val travelRepository: TravelRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : FlowUseCase<SetTravelRecordsUseCase.Params, Unit>(ioDispatcher) {

    override fun execute(params: Params): Flow<Result<Unit>> {
        TODO("Not yet implemented")
    }

    data class Params(val travel: Travel)
}
package com.teamunknown.application.usecase.travel

import com.teamunknown.application.di.IoDispatcher
import com.teamunknown.application.model.Travel
import com.teamunknown.application.utils.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

open class SetTravelRecordsUseCase @Inject constructor(
    private val travelRepository: TravelRepository,
    @IoDispatcher ioDispatcher: CoroutineDispatcher
) : UseCase<SetTravelRecordsUseCase.Params, Unit>(ioDispatcher) {

    override suspend fun execute(params: Params) {
        travelRepository.setTravelRecords(params.travel)
    }

    data class Params(val travel: Travel)
}
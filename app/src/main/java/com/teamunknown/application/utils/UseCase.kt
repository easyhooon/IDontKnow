package com.teamunknown.application.utils

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


abstract class UseCase<in Params, out Type>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(params: Params): Result<Type> {
        return try {
            // Moving all use case's executions to the injected dispatcher
            // In production code, this is usually the Default dispatcher (background thread)
            // In tests, this becomes a TestCoroutineDispatcher
            withContext(coroutineDispatcher) {
                execute(params).let {
                    Result.Success(it)
                }
            }
        } catch (e: Exception) {
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: Params): Type
}

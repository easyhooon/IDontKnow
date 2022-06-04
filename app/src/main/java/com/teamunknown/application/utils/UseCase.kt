package com.teamunknown.application.utils


abstract class UseCase<in Params, out Type> {

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(params: Params): Type
}

package com.teamunknown.application.repository.checklist

import com.teamunknown.application.model.CheckList
import com.teamunknown.application.repository.CheckListLocalDataSource
import com.teamunknown.application.usecase.checklist.CheckListRepository
import kotlinx.coroutines.flow.Flow
import com.teamunknown.application.utils.Result
import com.teamunknown.application.utils.Result.*


class CheckListRepositoryImpl (
    private val checkListLocalDataSource: CheckListLocalDataSource
): CheckListRepository {
    override fun getCheckList(travelId: Long): Flow<Result<List<CheckList>>>  {
        return checkListLocalDataSource.getCheckList(travelId)
    }

    override suspend fun updateCheckList(checkList: CheckList): Result<Unit> {
        return Success(checkListLocalDataSource.updateCheckList(checkList))
    }

    override suspend fun registerCheckList(checkList: CheckList): Result<Unit> {
        return Success(checkListLocalDataSource.insertCheckList(checkList))
    }

    override suspend fun clearCheckList(checkList: CheckList): Result<Unit> {
        return Success(checkListLocalDataSource.clearCheckList(checkList))
    }

    override suspend fun clearCheckList(): Result<Unit> {
        return Success(checkListLocalDataSource.clearCheckList())
    }
}
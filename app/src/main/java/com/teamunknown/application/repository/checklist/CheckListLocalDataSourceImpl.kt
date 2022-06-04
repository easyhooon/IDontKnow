package com.teamunknown.application.repository.checklist

import com.teamunknown.application.model.CheckList
import com.teamunknown.application.repository.CheckListLocalDataSource
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class CheckListLocalDataSourceImpl(
    private val travelDatabase: TravelDatabase
) : CheckListLocalDataSource {

    override fun getCheckList(travelId: Long): Flow<Result<List<CheckList>>> = flow {
        Result.Success(travelDatabase.checkListDao().getCheckList(travelId))
    }

    override suspend fun insertCheckList(checkList: CheckList) {
        travelDatabase.checkListDao().insertCheckList(checkList)
    }

    override suspend fun clearCheckList(checkLists: List<CheckList>) {
        travelDatabase.checkListDao().clearCheckList(checkLists)
    }

    override suspend fun clearCheckList() {
        travelDatabase.checkListDao().clearCheckList()
    }
}
package com.teamunknown.application.repository.checklist

import com.teamunknown.application.model.CheckList
import com.teamunknown.application.repository.CheckListLocalDataSource
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber


class CheckListLocalDataSourceImpl(
    private val travelDatabase: TravelDatabase
) : CheckListLocalDataSource {

    override fun getCheckList(travelId: Long): Flow<Result<List<CheckList>>> {
        Timber.d("CheckListLocalDataSourceImpl getCheckList 호출 $travelId")
        return travelDatabase.checkListDao().getCheckList(travelId).map { Result.Success(it) }
    }


    override suspend fun insertCheckList(checkList: CheckList) {
        travelDatabase.checkListDao().insertCheckList(checkList)
    }

    override suspend fun updateCheckList(checkList: CheckList) {
        travelDatabase.checkListDao().updateCheckList(checkList)
    }

    override suspend fun clearCheckList(checkLists: CheckList) {
        travelDatabase.checkListDao().clearCheckList(checkLists)
    }

    override suspend fun clearCheckList() {
        travelDatabase.checkListDao().clearCheckList()
    }
}
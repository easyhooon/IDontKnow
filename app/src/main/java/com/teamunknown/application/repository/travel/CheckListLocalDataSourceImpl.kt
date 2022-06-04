package com.teamunknown.application.repository.travel

import com.teamunknown.application.model.CheckList
import com.teamunknown.application.repository.CheckListLocalDataSource
import com.teamunknown.application.repository.TravelDatabase
import kotlinx.coroutines.flow.Flow


class CheckListLocalDataSourceImpl(
    private val travelDatabase: TravelDatabase
) : CheckListLocalDataSource {
    override suspend fun getCheckList(travelId: Long): Flow<List<CheckList>> {
        return travelDatabase.checkListDao().getCheckList(travelId)
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
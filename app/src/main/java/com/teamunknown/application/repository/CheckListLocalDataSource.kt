package com.teamunknown.application.repository

import com.teamunknown.application.model.CheckList
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow

interface CheckListLocalDataSource {

    fun getCheckList(travelId: Long) : Flow<Result<List<CheckList>>>

    suspend fun insertCheckList(checkList: CheckList)

    suspend fun updateCheckList(checkList: CheckList)

    suspend fun clearCheckList(checkLists:CheckList)

    suspend fun clearCheckList()
}
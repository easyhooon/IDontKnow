package com.teamunknown.application.repository

import com.teamunknown.application.model.CheckList
import kotlinx.coroutines.flow.Flow

interface CheckListLocalDataSource {

    suspend fun getCheckList(travelId: Long) : Flow<List<CheckList>>

    suspend fun insertCheckList(checkList: CheckList)

    suspend fun clearCheckList(checkLists:List<CheckList>)

    suspend fun clearCheckList()
}
package com.teamunknown.application.usecase.checklist

import com.teamunknown.application.model.CheckList
import kotlinx.coroutines.flow.Flow
import com.teamunknown.application.utils.Result

interface CheckListRepository {

    fun getCheckList(travelId: Long) : Flow<Result<List<CheckList>>>

    suspend fun updateCheckList(checkList: CheckList) : Result<Unit>

    suspend fun registerCheckList(checkList: CheckList) : Result<Unit>

    suspend fun clearCheckList(checkList: CheckList) : Result<Unit>

    suspend fun clearCheckList() : Result<Unit>
}
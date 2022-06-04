package com.teamunknown.application.repository

import com.teamunknown.application.model.Diary
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow

interface DiaryLocalDataSource {

    fun getDiaryList(travelId: Long?) : Flow<Result<List<Diary>>>

    suspend fun insertDiaryList(diary: Diary)

    suspend fun clearDiaryList(diaryLists:List<Diary>)

    suspend fun clearDiaryList()
}
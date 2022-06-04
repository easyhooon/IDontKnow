package com.teamunknown.application.usecase.diary

import com.teamunknown.application.model.Diary
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow

interface DiaryRepository {

    fun getDiaryList(travelId: Long?) : Flow<Result<List<Diary>>>

    suspend fun setDiary(diary: Diary)

    suspend fun clearDiary()
}
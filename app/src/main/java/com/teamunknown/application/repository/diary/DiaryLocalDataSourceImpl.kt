package com.teamunknown.application.repository.diary

import com.teamunknown.application.model.Diary
import com.teamunknown.application.repository.DiaryLocalDataSource
import com.teamunknown.application.repository.TravelDatabase
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DiaryLocalDataSourceImpl(
    private val travelDatabase: TravelDatabase
) : DiaryLocalDataSource {

    override fun getDiaryList(travelId: Long?): Flow<Result<List<Diary>>> = travelDatabase.diaryDao().getDiaryList(travelId).map { Result.Success(it) }

    override suspend fun insertDiaryList(diary: Diary) {
        travelDatabase.diaryDao().insertDiary(diary)
    }

    override suspend fun clearDiaryList(diaryLists: List<Diary>) {
        travelDatabase.diaryDao().clearDiary(diaryLists)
    }

    override suspend fun clearDiaryList() {
        travelDatabase.diaryDao().clearDiary()
    }
}
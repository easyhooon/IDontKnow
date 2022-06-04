package com.teamunknown.application.repository.diary

import com.teamunknown.application.model.Diary
import com.teamunknown.application.repository.DiaryLocalDataSource
import com.teamunknown.application.usecase.diary.DiaryRepository
import com.teamunknown.application.utils.Result
import kotlinx.coroutines.flow.Flow

class DiaryRepositoryImpl(
    private val diaryLocalDataSource: DiaryLocalDataSource
) : DiaryRepository {

    override fun getDiaryList(travelId: Long?): Flow<Result<List<Diary>>> {
        TODO("Not yet implemented")
    }

    override suspend fun setDiary(diary: Diary) {
        TODO("Not yet implemented")
    }

    override suspend fun clearDiary() {
        TODO("Not yet implemented")
    }
}
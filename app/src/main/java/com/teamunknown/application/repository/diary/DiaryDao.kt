package com.teamunknown.application.repository.diary

import androidx.room.*
import com.teamunknown.application.model.Diary
import kotlinx.coroutines.flow.Flow

@Dao
interface DiaryDao {

    @Query("SELECT * FROM diary WHERE travel_id is NULL OR id = :travelId")
    fun getDiaryList(travelId: Long?) : Flow<List<Diary>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDiary(diary: Diary)

    @Delete
    suspend fun clearDiary(diary: List<Diary>)

    @Query("DELETE FROM diary")
    suspend fun clearDiary()
}
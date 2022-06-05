package com.teamunknown.application.repository.checklist

import androidx.room.*
import com.teamunknown.application.model.CheckList
import kotlinx.coroutines.flow.Flow

@Dao
interface CheckListDao {
    @Query("SELECT * FROM checkList WHERE travel_id is NULL OR id = :travelId")
    fun getCheckList(travelId: Long?) : Flow<List<CheckList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCheckList(checkList: CheckList)

    @Update
    suspend fun updateCheckList(checkList: CheckList)

    @Delete
    suspend fun clearCheckList(checkList: CheckList)

    @Query("DELETE FROM checkList")
    suspend fun clearCheckList()
}
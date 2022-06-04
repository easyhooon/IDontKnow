package com.teamunknown.application.repository.travel

import androidx.room.*
import com.teamunknown.application.model.Travel
import kotlinx.coroutines.flow.Flow

@Dao
interface TravelDao {

    @Query("SELECT * FROM travel WHERE travel_id is NULL OR id = :travelId")
    fun getTravels(travelId: Long?): Flow<List<Travel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTravel(travel : Travel)

    @Delete
    suspend fun clearTravel(travel: List<Travel>)

    @Query("DELETE FROM travel")
    suspend fun clearTravel()
}
package com.teamunknown.application.repository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.teamunknown.application.model.CheckList
import com.teamunknown.application.model.Diary
import com.teamunknown.application.model.Travel
import com.teamunknown.application.repository.checklist.CheckListDao
import com.teamunknown.application.repository.travel.TravelDao

@Database(
    entities = [
        Travel::class,
        Diary::class,
        CheckList::class
    ],
    version = 1,
    exportSchema = false
)
abstract class TravelDatabase : RoomDatabase() {

    abstract fun travelDao() : TravelDao

    abstract fun checkListDao() : CheckListDao

    companion object {
        private const val dbName = "TRAVEL_DB"

        fun buildDatabase(context: Context): TravelDatabase {
            return Room.databaseBuilder(context, TravelDatabase::class.java, dbName)
                .fallbackToDestructiveMigration()
                .enableMultiInstanceInvalidation()
                .build()
        }
    }
}
package com.teamunknown.application.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diary")
data class Diary(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    @Transient
    val id: Int = 0,
    @ColumnInfo(name="travel_id")
    val travelId: Long,
    @ColumnInfo(name = "diary_title")
    val diaryTitle: String,
    @ColumnInfo(name = "diary_date")
    val diaryDate: String,
    @ColumnInfo(name = "diary_description")
    val diaryDescription: String
)
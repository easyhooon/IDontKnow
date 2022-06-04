package com.teamunknown.application.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "travel")
data class Travel(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = false)
    @Transient
    val id: Int = 0,
    @ColumnInfo(name="travel_id")
    val travelId: Long,
    @ColumnInfo(name = "travel_title")
    val travelTitle: String,
    @ColumnInfo(name = "start_date")
    val startDate: String,
    @ColumnInfo(name = "end_date")
    val endDate: String,
)
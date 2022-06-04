package com.teamunknown.application.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checkList")
data class CheckList(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    @Transient
    val id: Int = 0,
    @Transient
    @ColumnInfo(name="travel_id")
    val travelId: Long?,
    @Transient
    @ColumnInfo(name = "check_item")
    val checkItem: String,
    @Transient
    @ColumnInfo(name = "is_checkable")
    val isCheckable: Boolean
)
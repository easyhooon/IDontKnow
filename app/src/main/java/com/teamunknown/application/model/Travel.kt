package com.teamunknown.application.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity(tableName = "travel")
data class Travel(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    @Transient
    val id: Int = 0,
    @Transient
    @ColumnInfo(name = "travel_id")
    val travelId: Long?,
    @Transient
    @ColumnInfo(name = "travel_title")
    val travelTitle: String,
    @Transient
    @ColumnInfo(name = "start_date")
    val startDate: String,
    @Transient
    @ColumnInfo(name = "end_date")
    val endDate: String,
    @Transient
    @ColumnInfo(name = "image_url")
    val imageUrl: String
) : Parcelable
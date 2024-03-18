package com.omid.metro.model.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("LinesTbl")
data class LinesItem(
    @PrimaryKey(autoGenerate = true)
    val idPrimary: Int = 0,
    @SerializedName("color")
    @ColumnInfo("color")
    val color: String,
    @SerializedName("description")
    @ColumnInfo("description")
    val description: String,
    @SerializedName("id")
    @ColumnInfo("id")
    val id: String,
    @SerializedName("title")
    @ColumnInfo("title")
    val title: String,
    @SerializedName("title_english")
    @ColumnInfo("titleEnglish")
    val titleEnglish: String
) : Parcelable
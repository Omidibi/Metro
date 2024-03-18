package com.omid.metro.model.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity("StationsTbl")
data class StationsItem(
    @PrimaryKey(autoGenerate = true)
    val idPrimary: Int = 0,
    @SerializedName("address")
    @ColumnInfo("address")
    val address: String,
    @SerializedName("atm")
    @ColumnInfo("atm")
    val atm: String,
    @SerializedName("bus")
    @ColumnInfo("bus")
    val bus: String,
    @SerializedName("crossLineId")
    @ColumnInfo("crossLineId")
    val crossLineId: String,
    @SerializedName("elevator")
    @ColumnInfo("elevator")
    val elevator: String,
    @SerializedName("escalator")
    @ColumnInfo("escalator")
    val escalator: String,
    @SerializedName("id")
    @ColumnInfo("id")
    val id: String,
    @SerializedName("latitude")
    @ColumnInfo("latitude")
    val latitude: String,
    @SerializedName("lineId")
    @ColumnInfo("lineId")
    val lineId: String,
    @SerializedName("longitude")
    @ColumnInfo("longitude")
    val longitude: String,
    @SerializedName("lost")
    @ColumnInfo("lost")
    val lost: String,
    @SerializedName("orderId")
    @ColumnInfo("orderId")
    val orderId: String,
    @SerializedName("parking")
    @ColumnInfo("parking")
    val parking: String,
    @SerializedName("phone")
    @ColumnInfo("phone")
    val phone: String,
    @SerializedName("stationDuration")
    @ColumnInfo("stationDuration")
    val stationDuration: String,
    @SerializedName("taxi")
    @ColumnInfo("taxi")
    val taxi: String,
    @SerializedName("ticket")
    @ColumnInfo("ticket")
    val ticket: String,
    @SerializedName("title")
    @ColumnInfo("title")
    val title: String,
    @SerializedName("titleEnglish")
    @ColumnInfo("titleEnglish")
    val titleEnglish: String,
    @SerializedName("water")
    @ColumnInfo("water")
    val water: String
) : Parcelable
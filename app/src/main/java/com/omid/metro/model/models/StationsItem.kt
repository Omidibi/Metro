package com.omid.metro.model.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class StationsItem(
    @SerializedName("address")
    val address: String,
    @SerializedName("atm")
    val atm: String,
    @SerializedName("bus")
    val bus: String,
    @SerializedName("crossLineId")
    val crossLineId: String,
    @SerializedName("elevator")
    val elevator: String,
    @SerializedName("escalator")
    val escalator: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("lineId")
    val lineId: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("lost")
    val lost: String,
    @SerializedName("orderId")
    val orderId: String,
    @SerializedName("parking")
    val parking: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("stationDuration")
    val stationDuration: String,
    @SerializedName("taxi")
    val taxi: String,
    @SerializedName("ticket")
    val ticket: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("titleEnglish")
    val titleEnglish: String,
    @SerializedName("water")
    val water: String
) : Parcelable

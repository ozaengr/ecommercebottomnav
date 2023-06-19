package com.desire.ecommercebottomnav.ui.home

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class RcvModel(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Rating,
    val title: String
):Parcelable{
    @Parcelize
    data class Rating(
        var count: Int = 0,
        var rate: Double
    ) : Parcelable
}

package com.desire.ecommercebottomnav.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyProductListItem(
    @SerializedName("category")
    var category: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("image")
    var image: String = "",
    @SerializedName("price")
    var price: Double = 0.0,
    @SerializedName("rating")
    var rating: Rating = Rating(),
    @SerializedName("title")
    var title: String = ""
) : Parcelable {
    @Parcelize
    data class Rating(
        @SerializedName("count")
        var count: Int = 0,
        @SerializedName("rate")
        var rate: Double = 0.0
    ) : Parcelable
}

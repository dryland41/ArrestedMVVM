package com.example.codingchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Record(
    @SerializedName("book_date_formatted")
    @Expose
    var bookDateFormatted: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("mugshot")
    @Expose
    var mugshot: String? = null,

    @SerializedName("book_date")
    @Expose
    var bookDate: String? = null,

    @SerializedName("charges")
    @Expose
    var charges: List<String>? = null,

    @SerializedName("id")
    @Expose
    var id: Int? = null,

    @SerializedName("more_info_url")
    @Expose
    var moreInfoUrl: String? = null
)
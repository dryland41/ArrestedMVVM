package com.example.codingchallenge.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Jail (
    @SerializedName("city")
    @Expose
    var city: String? = null,

    @SerializedName("name")
    @Expose
    var name: String? = null,

    @SerializedName("url")
    @Expose
    var url: String? = null,

    @SerializedName("address1")
    @Expose
    var address1: String? = null,

    @SerializedName("address2")
    @Expose
    var address2: String? = null,

    @SerializedName("state")
    @Expose
    var state: String? = null
)
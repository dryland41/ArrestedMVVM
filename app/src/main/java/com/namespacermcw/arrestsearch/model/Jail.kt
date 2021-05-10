package com.namespacermcw.arrestsearch.model

class Jail (
    @com.squareup.moshi.Json(name = "city")
    var city: String? = null,

    @com.squareup.moshi.Json(name = "name")
    var name: String? = null,

    @com.squareup.moshi.Json(name = "url")
    var url: String? = null,

    @com.squareup.moshi.Json(name = "address1")
    var address1: String? = null,

    @com.squareup.moshi.Json(name = "address2")
    var address2: String? = null,

    @com.squareup.moshi.Json(name = "state")
    var state: String? = null
)
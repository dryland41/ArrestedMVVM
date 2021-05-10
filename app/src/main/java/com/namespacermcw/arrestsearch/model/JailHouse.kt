package com.namespacermcw.arrestsearch.model

data class JailHouse (
    @com.squareup.moshi.Json(name = "status")
    var status: Int? = null,

    @com.squareup.moshi.Json(name = "next_page")
    var nextPage: Int? = null,

    @com.squareup.moshi.Json(name = "records")
    var records: List<Record>? = null,

    @com.squareup.moshi.Json(name = "current_page")
    var currentPage: Int? = null,

    @com.squareup.moshi.Json(name = "total_records")
    var totalRecords: Int? = null,

    @com.squareup.moshi.Json(name = "jail")
    var jail: Jail? = null,

    @com.squareup.moshi.Json(name = "msg")
    var msg: String? = null
)
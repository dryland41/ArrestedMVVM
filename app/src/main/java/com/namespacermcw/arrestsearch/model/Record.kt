package com.namespacermcw.arrestsearch.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "records"
)

data class Record (
    @PrimaryKey(autoGenerate = true)
    val primaryKey : Int,

    @com.squareup.moshi.Json(name = "book_date_formatted")
    var bookDateFormatted: String? = null,

    @com.squareup.moshi.Json(name = "name")
    var name: String? = null,

    @com.squareup.moshi.Json(name = "mugshot")
    var mugshot: String? = null,

    @com.squareup.moshi.Json(name = "book_date")
    var bookDate: String? = null,

    @com.squareup.moshi.Json(name = "charges")
    var charges: List<String>? = null,

    @com.squareup.moshi.Json(name = "id")
    var id: Int? = null,

    @com.squareup.moshi.Json(name = "more_info_url")
    var moreInfoUrl: String? = null
)
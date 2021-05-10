package com.namespacermcw.arrestsearch.dao

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.namespacermcw.arrestsearch.model.Record

//This class let's Room know how to deal with complex types

@ProvidedTypeConverter
class Converter {
    val gson : Gson = Gson()

    @TypeConverter
    fun recordToJson(record: Record) : String {
        return gson.toJson(record)
    }

    @TypeConverter
    fun jsonToRecord(json : String) : Record {
        return gson.fromJson(json, Record::class.java)
    }

    @TypeConverter
    fun stringListToJson(stringList: List<String>): String {
        return gson.toJson(stringList)
    }

    @TypeConverter
    fun jsonToStringList(json: String): List<String>{
        return gson.fromJson(json, object : TypeToken<List<String>>() {}.type)
        //return gson.fromJson(json, Builder(List::class.java as Class<List<String>>))
    }

}
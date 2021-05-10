package com.namespacermcw.arrestsearch.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.namespacermcw.arrestsearch.model.Record

@Database(entities = arrayOf(Record::class), version = 1)
@TypeConverters(Converter::class)
abstract class Database : RoomDatabase() {
    abstract fun recordsDao(): ArrestSearchDao
}
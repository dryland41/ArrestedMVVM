package com.namespacermcw.arrestsearch.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.namespacermcw.arrestsearch.models.Record

@Dao

interface ArrestSearchDao {

    @Query("SELECT * FROM records")
    fun queryRecords(): LiveData<List<Record>>

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    fun insertRecord(record: Record)

}
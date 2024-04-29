package com.managerofthings.sqllite.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.managerofthings.sqllite.tables.Contains

@Dao
interface ContainsDAO {
    @Query("SELECT * FROM contains")
    fun getAll(): List<Contains>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContains(contains: Contains)

    @Delete
    fun delete(contains: Contains)
}
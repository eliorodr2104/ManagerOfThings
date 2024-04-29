package com.managerofthings.sqllite.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.managerofthings.sqllite.tables.Tags

@Dao
interface TagsDAO {
    @Query("SELECT * FROM tags")
    fun getAll(): List<Tags>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTags(tags: Tags)

    @Delete
    fun delete(tags: Tags)
}
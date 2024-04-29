package com.managerofthings.sqllite.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.managerofthings.sqllite.tables.CategoryHasTags

@Dao
interface CategoryHasTagsDAO {
    @Query("SELECT * FROM categoryhastags")
    fun getAll(): List<CategoryHasTags>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategoryHasTags(categoryHasTags: CategoryHasTags)

    @Delete
    fun delete(categoryhastags: CategoryHasTags)
}
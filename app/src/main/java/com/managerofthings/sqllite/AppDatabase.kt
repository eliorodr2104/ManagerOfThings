package com.managerofthings.sqllite

import androidx.room.Database
import androidx.room.RoomDatabase
import com.managerofthings.sqllite.daos.BullshitDAO
import com.managerofthings.sqllite.daos.CategoryDAO
import com.managerofthings.sqllite.daos.CategoryHasTagsDAO
import com.managerofthings.sqllite.daos.ContainsDAO
import com.managerofthings.sqllite.daos.TagsDAO
import com.managerofthings.sqllite.tables.Bullshit
import com.managerofthings.sqllite.tables.Category
import com.managerofthings.sqllite.tables.CategoryHasTags
import com.managerofthings.sqllite.tables.Contains
import com.managerofthings.sqllite.tables.Tags

@Database(
    entities = [
        Bullshit::class,
        Category::class,
        CategoryHasTags::class,
        Contains::class,
        Tags::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bullshitDAO(): BullshitDAO
    abstract fun categoryDAO(): CategoryDAO
    abstract fun categoryHasTagDAO(): CategoryHasTagsDAO
    abstract fun containsDAO(): ContainsDAO
    abstract fun tagsDAO(): TagsDAO
}
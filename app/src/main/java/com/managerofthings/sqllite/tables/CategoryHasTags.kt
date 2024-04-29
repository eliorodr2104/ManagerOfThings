package com.managerofthings.sqllite.tables

import androidx.room.Entity

@Entity(
    tableName = "categoryhastags",
    primaryKeys = ["nameCategory", "idTags"]
)
data class CategoryHasTags(
    var nameCategory: String,
    var idTags: Int
)
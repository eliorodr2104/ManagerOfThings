package com.managerofthings.sqllite.tables

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class CategoryWithTags(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "name",
        entityColumn = "nameCategory",
        associateBy = Junction(CategoryHasTags::class)
    )
    val subjects: List<Tags>
)
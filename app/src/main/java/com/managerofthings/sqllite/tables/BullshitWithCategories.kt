package com.managerofthings.sqllite.tables

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class BullshitWithCategories(
    @Embedded val bullshit: Bullshit,
    @Relation(
        parentColumn = "id",
        entityColumn = "name",
        associateBy = Junction(Contains::class)
    )
    val categories: List<Category>?
)


package com.managerofthings.sqllite.tables

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "contains",
    primaryKeys = ["id", "name"],
    foreignKeys = [
        ForeignKey(
            entity = Bullshit::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        ),

        ForeignKey(
            entity = Category::class,
            parentColumns = ["name"],
            childColumns = ["name"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Contains(
    var id: Int,
    var name: String
)

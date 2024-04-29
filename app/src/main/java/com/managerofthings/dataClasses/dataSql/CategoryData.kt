package com.managerofthings.dataClasses.dataSql

import com.managerofthings.sqllite.tables.Category
import com.managerofthings.sqllite.tables.Tags

data class CategoryData(
    val category: Category,
    val tagArray: List<Tags>
)
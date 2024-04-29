package com.managerofthings.dataClasses.dataSql

import com.managerofthings.sqllite.tables.Bullshit

data class BullshitData(
    val bullshit: Bullshit,
    val categorys: List<CategoryData>
)
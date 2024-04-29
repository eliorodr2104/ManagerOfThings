package com.managerofthings.dataClasses

import java.util.UUID

data class ItemTag(
    val nameItem: String,
    val id: String = UUID.randomUUID().toString()
)

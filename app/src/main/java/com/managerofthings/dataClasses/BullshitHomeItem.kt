package com.managerofthings.dataClasses

import java.util.UUID

data class BullshitHomeItem(
    val image: String,
    val id: String = UUID.randomUUID().toString()
)

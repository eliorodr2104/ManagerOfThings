package com.managerofthings.dataClasses

import androidx.compose.ui.graphics.vector.ImageVector

data class ItemShortcut(
    var name: String,
    var image: ImageVector,
    var onClick: () -> Unit
)

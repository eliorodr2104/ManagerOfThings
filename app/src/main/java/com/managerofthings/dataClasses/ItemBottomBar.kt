package com.managerofthings.dataClasses

import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.runtime.Composable

data class ItemBottomBar(
    val selected: () -> Boolean,
    var onclick: () -> Unit,
    var icon: @Composable () -> Unit,
    var label: @Composable () -> Unit,
    var colors: NavigationBarItemColors
)

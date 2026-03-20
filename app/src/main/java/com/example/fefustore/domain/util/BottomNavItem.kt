package com.example.fefustore.domain.util

import androidx.compose.ui.graphics.painter.Painter
import com.example.fefustore.presentation.screen.main.navigation.MainScreenNavRoute

data class BottomNavItem(
    val icon: Painter,
    val titleResId: Int,
    val route: MainScreenNavRoute
)

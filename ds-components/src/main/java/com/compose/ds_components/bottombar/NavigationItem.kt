package com.compose.ds_components.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector


sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Default.Home, "Home")
    object Favorites : NavigationItem("favorite", Icons.Default.Star, "Favorites")
}
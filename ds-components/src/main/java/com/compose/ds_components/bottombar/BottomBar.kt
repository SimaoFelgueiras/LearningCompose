package com.compose.ds_components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.navigation.NavController
import com.compose.ds_components.bottombar.NavigationItem
import com.compose.ds_components.theme.Purple200
import com.compose.ds_components.theme.Teal200

@Composable
fun BottomNavigationBar(items: List<NavigationItem>, navController: NavController) {
    BottomNavigation(
        backgroundColor = Teal200,
        contentColor = Black
    ) {
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Purple200,
                unselectedContentColor = Gray,
                alwaysShowLabel = true,
                selected = true,
                onClick = {
                    navController.navigate(item.route) {
                        // Pop up to the start destination of the graph to
                        // avoid building up a large stack of destinations
                        // on the back stack as users select items
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        // Avoid multiple copies of the same destination when
                        // reselecting the same item
                        launchSingleTop = true
                        // Restore state when reselecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
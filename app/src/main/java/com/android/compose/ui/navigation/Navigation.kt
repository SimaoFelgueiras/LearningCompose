package com.android.compose.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun MainScreen() {

    val navController = rememberNavController()
    mainScreenNavigation(navController = navController)
}

@Composable
private fun mainScreenNavigation(
    navController: NavHostController
) {
//    NavHost(navController, tartDestination = "dogs") {
//        composable("dogs") { DogsFragment.newInstance() }
//    }
}

package com.android.compose.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.ds_components.BottomNavigationBar
import com.compose.ds_components.TopBar
import com.compose.ds_components.NavigationItem
import com.android.compose.ui.dogs.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DogsViewModel by viewModels()


    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MainScreen()
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        MaterialTheme {
            Surface(color = MaterialTheme.colors.background) {
                Scaffold(
                    topBar = {
                        com.compose.ds_components.TopBar()
                    },
                    bottomBar = {
                        com.compose.ds_components.BottomNavigationBar(
                            listOf(
                                com.compose.ds_components.NavigationItem.Home,
                                com.compose.ds_components.NavigationItem.Favorites
                            ), navController
                        )
                    }) {
                    Navigation(navController)
                }
            }
        }

    }

    @ExperimentalFoundationApi
    @Composable
    fun Navigation(navController: NavHostController) {
        NavHost(navController, startDestination = com.compose.ds_components.NavigationItem.Home.route) {
            composable(com.compose.ds_components.NavigationItem.Home.route) {
                DogsScreen(viewModel)
            }
            composable(com.compose.ds_components.NavigationItem.Favorites.route) {

            }

        }
    }
}
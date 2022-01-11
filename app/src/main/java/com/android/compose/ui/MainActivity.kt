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
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.compose.R
import com.android.compose.ui.dogs.*
import com.compose.ds_components.BottomNavigationBar
import com.compose.ds_components.TopBar
import com.compose.ds_components.bottombar.NavigationItem
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DogsViewModel by viewModels()
    private val bottomBarItems = listOf(
        NavigationItem.Home,
        NavigationItem.Favorites,
        NavigationItem.Settings
    )

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
                        TopBar(this.getString(R.string.app_name))
                    },
                    bottomBar = {
                        BottomNavigationBar(
                            bottomBarItems,
                            navController
                        )
                    }) {
                    NavigationGraph(navController = navController)
                }
            }
        }

    }

    @ExperimentalFoundationApi
    @Composable
    fun NavigationGraph(navController: NavHostController) {
        NavHost(navController, startDestination = NavigationItem.Home.route) {
            composable(NavigationItem.Home.route) {
                DogsScreen(viewModel)
            }
            composable(NavigationItem.Favorites.route) {

            }
            composable(NavigationItem.Settings.route) {

            }
        }
    }
}
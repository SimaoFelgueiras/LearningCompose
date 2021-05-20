package com.android.compose.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.android.compose.data.remote.entities.Dog
import com.android.compose.ui.dogs.DogsScreen
import com.android.compose.ui.dogs.DogsViewModel
import com.android.compose.ui.navigation.MainScreen
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DogsViewModel by viewModels()

    val tmpDogList = listOf(Dog("Teste"),Dog("Teste"),Dog("Teste"),Dog("Teste"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DogsScreen(Modifier,tmpDogList)
                }
            }

        }
    }
}
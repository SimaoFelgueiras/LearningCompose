package com.android.compose.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.*
import com.android.compose.data.remote.entities.Dog
import com.android.compose.ui.dogs.*
import com.android.compose.ui.navigation.MainScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DogsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.d("TESTE", "fetching dog")
        viewModel.invokeAction(DogsVmContract.Action.FetchDogs("working_dog"))
        Log.d("TESTE", "requesting")

        setContent {
            MaterialTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DogsScreen(viewModel)
                }
            }
        }
    }
}
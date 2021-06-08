package com.android.compose.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.android.compose.ui.dogs.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: DogsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.d("TESTE", "fetching dog")
        viewModel.invokeAction(DogsVmContract.Action.FetchDogs("terrier"))
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
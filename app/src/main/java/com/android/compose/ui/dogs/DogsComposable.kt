package com.android.compose.ui.dogs

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.compose.ui.dogs.DogsVmContract.State.DogsPage


@Composable
fun DogsScreen(dogsVM: DogsViewModel) {

    val dogsState by dogsVM.uiState.collectAsState()


    when (dogsState) {
        is DogsPage -> {
            DogsSuccessScreen(dogsList = (dogsState as DogsPage).dogsList)
        }
        DogsVmContract.State.DefaultState -> {
        }
        DogsVmContract.State.ErrorScreen -> {
            ErrorScreen()
        }
        DogsVmContract.State.LoadingScreen -> {
            LoadingScreen()
        }
    }

}

@Composable
fun DogsSuccessScreen(modifier: Modifier = Modifier, dogsList: List<String>) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dogsList) { dogs ->
            DogCard(
                modifier = Modifier.fillMaxWidth(),
                dogPicture = dogs
            )
        }
    }
}

@Composable
fun DogCard(
    modifier: Modifier = Modifier,
    dogPicture: String
) {

    Card(modifier = modifier, elevation = 8.dp) {
        Row(modifier = Modifier.padding(8.dp)) {
            //TODO to be replaced with an image
            Text(text = dogPicture)
        }
    }
}


@Composable
fun ErrorScreen() {
    Text("Error on the Request")
}

@Composable
fun LoadingScreen() {
    Text("Loading")
}
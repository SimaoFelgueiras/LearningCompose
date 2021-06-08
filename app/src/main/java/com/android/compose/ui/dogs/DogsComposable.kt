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
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.compose.data.remote.entities.Dog
import com.android.compose.ui.dogs.DogsVmContract.Action.FetchDogs
import com.android.compose.ui.dogs.DogsVmContract.State.DogsPage


@Composable
fun DogsScreen(dogsVM: DogsViewModel) {

    val dogsState by dogsVM.uiState.collectAsState()


    when (dogsState) {
        is DogsPage -> {
            Log.d("TESTE", "success")
            DogsSuccessScreen(dogsList = (dogsState as DogsPage).dogsList)
        }
        DogsVmContract.State.DefaultState -> {
        }
        DogsVmContract.State.ErrorScreen -> {
            ErrorScreen()
            Log.d("TESTE", "error")
        }
        DogsVmContract.State.LoadingScreen -> {
            Log.d("TESTE", "loading")
        }
    }

}

@Composable
fun DogsSuccessScreen(modifier: Modifier = Modifier, dogsList: List<Dog>) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(dogsList) { dogs ->
            DogCard(
                modifier = Modifier.fillMaxWidth(),
                dogPicture = dogs.status ?: ""
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
package com.android.compose.ui.dogs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.transform.CircleCropTransformation
import com.android.compose.ui.dogs.DogsVmContract.State.DogsPage
import com.google.accompanist.coil.rememberCoilPainter


@Composable
fun DogsScreen(dogsVM: DogsViewModel) {

    val dogsState by dogsVM.uiState.collectAsState()

    when (dogsState) {
        is DogsPage -> DogsSuccessScreen(dogsList = (dogsState as DogsPage).dogsList)
        DogsVmContract.State.DefaultState -> Unit
        DogsVmContract.State.ErrorScreen -> ErrorScreen()
        DogsVmContract.State.LoadingScreen -> LoadingScreen()
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
            Image(
                painter = rememberCoilPainter(
                    request = dogPicture,
                    requestBuilder = {
                        transformations(CircleCropTransformation())
                    },
                    fadeIn = true
                ),
                contentDescription = "",
                modifier = modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
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
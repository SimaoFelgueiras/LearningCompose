package com.android.compose.ui.dogs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.compose.ui.components.ErrorScreen
import com.android.compose.ui.components.LoadingRoundImage
import com.android.compose.ui.components.LoadingScreen
import com.android.compose.ui.dogs.DogsVmContract.State.DogsPage


@ExperimentalFoundationApi
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

@ExperimentalFoundationApi
@Composable
fun DogsSuccessScreen(modifier: Modifier = Modifier, dogsList: List<String>) {

    LazyVerticalGrid(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
        cells = GridCells.Fixed(2)
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
    Card(modifier = modifier.padding(PaddingValues(4.dp)), elevation = 8.dp) {
        Row(modifier = Modifier.padding(8.dp)) {
            LoadingRoundImage(image = dogPicture, modifier = modifier)
        }
    }
}
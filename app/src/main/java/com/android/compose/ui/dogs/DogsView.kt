package com.android.compose.ui.dogs

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.ds_components.ErrorScreen
import com.compose.ds_components.LoadingRoundImage
import com.compose.ds_components.LoadingScreen
import com.compose.ds_components.SearchView
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
    val text = remember { mutableStateOf(TextFieldValue(HINT)) }
    Column {
        SearchView(text)
        LazyVerticalGrid(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 8.dp),
            cells = GridCells.Fixed(2)
        ) {
            items(dogsList) { dogs ->
                DogCard(
                    dogPicture = dogs
                )
            }
        }
    }
}

@Composable
fun DogCard(
    dogPicture: String
) {
    Card(modifier = Modifier.padding(PaddingValues(4.dp)), elevation = 8.dp) {
        Row(modifier = Modifier.padding(8.dp)) {
            LoadingRoundImage(image = dogPicture)
        }
    }
}

@Composable
fun PreviewTest(){
    Text(text = "Test Preview")
}


@Preview(showBackground = true)
@Composable
private fun DogScreenPreview(){
    MaterialTheme {
        PreviewTest()
    }
}

private const val LABEL = "Insert a Dog Race"
private const val HINT = "Click to insert a Dog Race"
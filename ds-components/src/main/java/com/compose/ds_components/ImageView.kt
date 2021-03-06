package com.compose.ds_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import coil.transform.CircleCropTransformation
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState

@Composable
fun LoadingRoundImage(image: String) {
    val painter = rememberCoilPainter(
        request = image,
        requestBuilder = {
            transformations(CircleCropTransformation())
        }
    )

    Box {
        Image(
            painter = painter,
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillWidth
        )
        when (painter.loadState) {
            //using coil loading default
            is ImageLoadState.Error -> {
                // If you wish to display some content if the request fails
                Icon(
                    imageVector = Icons.Filled.Error,
                    contentDescription = "Error"
                )
            }
            else -> Unit
        }
    }
}
package com.compose.ds_components

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.sp
import com.compose.ds_components.theme.Purple700

@Composable
fun TopBar(title:String) {
    TopAppBar(
        title = { Text(text = title, fontSize = 18.sp) },
        backgroundColor = Purple700,
        contentColor = White
    )
}
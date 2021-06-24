package com.android.compose.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier


@Composable
fun SearchView(label: String, hint: String) {

    var text by remember { mutableStateOf(hint) }
    TextField(
        value = text,
        modifier = Modifier.fillMaxWidth(),
        onValueChange = { text = it },
        label = { Text(label) }
    )
}
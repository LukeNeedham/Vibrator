package com.lukeneedham.vibrator.ui.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainPageContent(isVibrating: Boolean, onToggleVibrate: () -> Unit) {

    val text = if (isVibrating) {
        "Stop"
    } else {
        "Start"
    }

    Column {
        Button(onClick = onToggleVibrate, modifier = Modifier.fillMaxSize()) {
            Text(text = text)
        }
    }
}

@Preview
@Composable
private fun PreviewMainPageContent() {
    MainPageContent(
        isVibrating = true,
        onToggleVibrate = {},
    )
}
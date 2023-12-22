package com.lukeneedham.vibrator.ui.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainPage(
    setVibrating: (isVibrating: Boolean) -> Unit,
) {
    var isVibrating by remember { mutableStateOf(false) }

    MainPageContent(
        isVibrating = isVibrating,
        onToggleVibrate = {
            isVibrating = !isVibrating
            setVibrating(isVibrating)
        }
    )
}

@Preview
@Composable
private fun PreviewMainPage() {
    MainPage(
        setVibrating = {},
    )
}
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
    MainPageContent(
        startVibration = { setVibrating(true) },
        stopVibration = { setVibrating(false) },
    )
}
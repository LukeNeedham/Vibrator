package com.lukeneedham.vibrator.ui.main

import androidx.compose.runtime.Composable

@Composable
fun MainPage(
    setVibrating: (isVibrating: Boolean) -> Unit,
) {
    MainPageContent(
        startVibration = { setVibrating(true) },
        stopVibration = { setVibrating(false) },
    )
}
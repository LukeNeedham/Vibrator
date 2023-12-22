package com.lukeneedham.vibrator.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.lukeneedham.vibrator.R

@Composable
fun MainPageContent(startVibration: () -> Unit, stopVibration: () -> Unit) {
    val startColor = Color(0xFF5D9C59)
    val stopColor = Color(0xFFDF2E38)

    Column {
        @Composable
        fun Button(text: String, color: Color, onClick: () -> Unit) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .background(color = color)
                    .clickable { onClick() }
            ) {
                Text(text = text, color = Color.White, fontSize = 40.sp)
            }
        }

        Button(
            text = stringResource(id = R.string.vibration_start),
            color = startColor,
            onClick = startVibration,
        )
        Button(
            text = stringResource(id = R.string.vibration_stop),
            color = stopColor,
            onClick = stopVibration,
        )
    }
}

@Preview
@Composable
private fun PreviewMainPageContent() {
    MainPageContent(
        startVibration = {},
        stopVibration = {},
    )
}
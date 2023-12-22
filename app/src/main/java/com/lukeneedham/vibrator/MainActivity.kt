package com.lukeneedham.vibrator

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.VibrationEffect.EFFECT_HEAVY_CLICK
import android.os.Vibrator
import android.os.VibratorManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.lukeneedham.vibrator.ui.main.MainPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainPage(
                setVibrating = ::setVibrating
            )
        }
    }

    private fun setVibrating(isVibrating: Boolean) {
        if (isVibrating) {
            startVibrating()
        } else {
            stopVibrating()
        }
    }

    private fun startVibrating() {
        val maxAmplitude = 255
        val sectionDurationMillis = 1000L

        /** Repeat the pattern from index 0 so the whole pattern replays */
        val repeatAtIndex = 0

        val vibrator = getVibrator()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val timings = longArrayOf(sectionDurationMillis)
            // Play at highest amplitude
            val amplitudes = intArrayOf(maxAmplitude)

            val effect = VibrationEffect.createWaveform(timings, amplitudes, repeatAtIndex)
            vibrator.vibrate(effect)
        } else {
            val initalDelay = 0L
            val pattern = longArrayOf(initalDelay, sectionDurationMillis)
            @Suppress("DEPRECATION")
            vibrator.vibrate(pattern, repeatAtIndex)
        }
    }

    private fun stopVibrating() {
        val vibrator = getVibrator()
        vibrator.cancel()
    }

    private fun getVibrator(): Vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        val vibratorManager =
            getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
        vibratorManager.defaultVibrator
    } else {
        @Suppress("DEPRECATION")
        getSystemService(VIBRATOR_SERVICE) as Vibrator
    }
}
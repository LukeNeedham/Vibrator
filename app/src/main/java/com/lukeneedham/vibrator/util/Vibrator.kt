package com.lukeneedham.vibrator.util

import android.content.Context
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.os.VibratorManager
import androidx.activity.ComponentActivity

/** High-level util for using the system vibrator APIs. Abstracts away legacy and deprecated APIs */
class Vibrator(context: Context) {
    /**
     * The maximum amplitude (force) that a vibration can have.
     * Depends on the hardware being able to handle custom vibration amplitude.
     */
    private val maxAmplitude = 255

    /**
     * The duration of each section of the pattern.
     * If this value is too large then at some point it seems the system will cut the vibration off.
     * So as a workaround we loop a short vibration forever.
     */
    private val sectionDurationMillis = 1000L

    /** Repeat the pattern from index 0 so the whole pattern replays */
    private val repeatAtIndex = 0

    private val vibrator = getVibrator(context)

    fun start() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val timings = longArrayOf(sectionDurationMillis)
            val amplitudes = intArrayOf(maxAmplitude)
            val effect = VibrationEffect.createWaveform(timings, amplitudes, repeatAtIndex)
            vibrator.vibrate(effect)
        } else {
            /** The amount of delay between requesting vibration and the vibration actually starting */
            val initialDelay = 0L
            val pattern = longArrayOf(initialDelay, sectionDurationMillis)
            @Suppress("DEPRECATION")
            vibrator.vibrate(pattern, repeatAtIndex)
        }
    }

    fun stop() {
        vibrator.cancel()
    }

    private fun getVibrator(context: Context): Vibrator =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager =
                context.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            @Suppress("DEPRECATION")
            context.getSystemService(ComponentActivity.VIBRATOR_SERVICE) as Vibrator
        }
}
package com.hedgehog.scanner.domain

import android.graphics.drawable.Drawable

data class AppModel(
    val drawable: Drawable,
    val appName: String,
    val packageName: String,
)
package com.hedgehog.scanner.data

import android.graphics.drawable.Drawable

data class AppImageNameModel(
    val drawable: Drawable,
    val appName: String,
    val packageName: String,
)
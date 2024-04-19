package com.example.meditateui

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class features(
    val title : String,
    @DrawableRes val iconid : Int,
    val lightcolor : Color,
    val mediumcolor : Color,
    val darkcolor : Color
)

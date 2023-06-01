package com.example.healthyapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class HealthyOne(
    @StringRes val sumberTesk: Int,
    val sumberAngka: Int,
    @DrawableRes val sumberGambar: Int
) {

}
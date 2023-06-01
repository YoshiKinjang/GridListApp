package com.example.healthyapp.data

import com.example.healthyapp.R
import  com.example.healthyapp.model.HealthyOne

class DataResource {
    fun loadHealthyOne(): List<HealthyOne> {
        return listOf<HealthyOne>(
            HealthyOne(R.string.architecture, 58, R.drawable.architecture),
            HealthyOne(R.string.crafts, 121, R.drawable.crafts),
            HealthyOne(R.string.business, 78, R.drawable.business),
            HealthyOne(R.string.culinary, 118, R.drawable.culinary),
            HealthyOne(R.string.design, 423, R.drawable.design),
            HealthyOne(R.string.fashion, 92, R.drawable.fashion),
            HealthyOne(R.string.film, 165, R.drawable.film),
            HealthyOne(R.string.gaming, 164, R.drawable.gaming),
            HealthyOne(R.string.drawing, 326, R.drawable.drawing),
            HealthyOne(R.string.lifestyle, 305, R.drawable.lifestyle),
            HealthyOne(R.string.music, 212, R.drawable.music),
            HealthyOne(R.string.painting, 172, R.drawable.painting),
            HealthyOne(R.string.photography, 321, R.drawable.photography),
            HealthyOne(R.string.tech, 118, R.drawable.tech)
        )
    }
}
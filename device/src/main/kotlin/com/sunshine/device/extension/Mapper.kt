package com.sunshine.device.extension

import android.location.Location
import com.sunshine.data.model.CoordEntity

fun Location.toEntity() = CoordEntity(
    latitude = latitude,
    longitude = longitude
)
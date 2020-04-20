package com.sunshine.data.extension

import com.sunshine.data.model.CoordEntity
import com.sunshine.domain.model.Coord

fun CoordEntity.toDomain() = Coord(
    latitude = latitude,
    longitude = longitude
)
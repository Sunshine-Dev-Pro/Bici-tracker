package com.sunshine.domain.repository

import com.sunshine.domain.model.Coord
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getLastKnowLocation(): Coord
    fun getLocationUpdates(intervalInMillis: Long = 1000): Flow<Coord>
    fun getCurrentLocation()
}
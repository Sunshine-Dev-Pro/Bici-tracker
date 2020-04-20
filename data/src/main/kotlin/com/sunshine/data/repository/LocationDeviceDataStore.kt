package com.sunshine.data.repository

import com.sunshine.data.model.CoordEntity
import kotlinx.coroutines.flow.Flow

interface LocationDeviceDataStore {
    fun getLastKnowLocation(): CoordEntity
    fun getLocationUpdates(intervalInMillis: Long): Flow<CoordEntity>
    fun getCurrentLocation(): Flow<CoordEntity>
}
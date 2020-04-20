package com.sunshine.data.repository

import com.sunshine.data.model.CoordEntity
import kotlinx.coroutines.flow.Flow

interface LocationCacheDataStore {
    fun getLastKnowLocation(): CoordEntity
    fun getLocationUpdates(intervalInMillis: Long): Flow<CoordEntity>
    fun getCurrentLocation(): Flow<CoordEntity>
}
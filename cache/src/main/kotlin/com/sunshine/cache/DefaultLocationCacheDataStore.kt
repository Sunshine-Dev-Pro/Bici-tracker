package com.sunshine.cache

import com.sunshine.data.model.CoordEntity
import com.sunshine.data.repository.LocationCacheDataStore
import kotlinx.coroutines.flow.Flow

class DefaultLocationCacheDataStore : LocationCacheDataStore {

    override fun getLastKnowLocation(): CoordEntity {
        TODO("Not yet implemented")
    }

    override fun getLocationUpdates(intervalInMillis: Long): Flow<CoordEntity> {
        TODO("Not yet implemented")
    }

    override fun getCurrentLocation(): Flow<CoordEntity> {
        TODO("Not yet implemented")
    }
}
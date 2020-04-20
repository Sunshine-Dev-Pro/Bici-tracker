package com.sunshine.remote

import com.sunshine.data.model.CoordEntity
import com.sunshine.data.repository.LocationRemoteDataStore
import kotlinx.coroutines.flow.Flow

class DefaultLocationRemoteDataStore : LocationRemoteDataStore {

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
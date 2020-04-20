package com.sunshine.data.repository

import com.sunshine.data.extension.toDomain
import com.sunshine.data.store.LocationDataStoreFactory
import com.sunshine.domain.model.Coord
import com.sunshine.domain.repository.LocationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultLocationRepository(
    val factory: LocationDataStoreFactory
) : LocationRepository {

    override fun getLastKnowLocation(): Coord {
        TODO("Not yet implemented")
    }

    override fun getLocationUpdates(intervalInMillis: Long): Flow<Coord> =
        factory.device
            .getLocationUpdates(intervalInMillis = intervalInMillis)
            .map { it.toDomain() }

    override fun getCurrentLocation(): Flow<Coord> {
        TODO("Not yet implemented")
    }
}
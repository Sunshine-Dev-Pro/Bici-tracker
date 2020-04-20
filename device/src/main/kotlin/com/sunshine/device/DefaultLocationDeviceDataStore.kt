package com.sunshine.device

import com.google.android.gms.location.LocationRequest
import com.sunshine.data.model.CoordEntity
import com.sunshine.data.repository.LocationDeviceDataStore
import com.sunshine.device.extension.toEntity
import com.sunshine.device.location.fusedLocationFlow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DefaultLocationDeviceDataStore : LocationDeviceDataStore {

    private val locationRequest by lazy { LocationRequest() }

    override fun getLastKnowLocation(): CoordEntity {
        TODO("Not yet implemented")
    }

    override fun getLocationUpdates(intervalInMillis: Long): Flow<CoordEntity> =
        fusedLocationFlow(
            configLocationRequest = { locationRequest.interval = intervalInMillis }
        ).map { it.toEntity() }

    override fun getCurrentLocation(): Flow<CoordEntity> {
        TODO("Not yet implemented")
    }
}
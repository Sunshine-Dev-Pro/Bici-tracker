package com.sunshine.data.store

import com.sunshine.data.repository.LocationCacheDataStore
import com.sunshine.data.repository.LocationDeviceDataStore
import com.sunshine.data.repository.LocationRemoteDataStore

open class LocationDataStoreFactory(
    val cache: LocationCacheDataStore,
    val remote: LocationRemoteDataStore,
    val device: LocationDeviceDataStore
)
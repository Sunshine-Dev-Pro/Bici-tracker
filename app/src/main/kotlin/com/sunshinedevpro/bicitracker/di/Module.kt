package com.sunshinedevpro.bicitracker.di

import com.sunshine.cache.DefaultLocationCacheDataStore
import com.sunshine.data.repository.DefaultLocationRepository
import com.sunshine.data.repository.LocationCacheDataStore
import com.sunshine.data.repository.LocationDeviceDataStore
import com.sunshine.data.repository.LocationRemoteDataStore
import com.sunshine.data.store.LocationDataStoreFactory
import com.sunshine.device.DefaultLocationDeviceDataStore
import com.sunshine.domain.base.AppCoroutineDispatchers
import com.sunshine.domain.interactor.ObserveCurrentLocation
import com.sunshine.domain.repository.LocationRepository
import com.sunshine.remote.DefaultLocationRemoteDataStore
import com.sunshinedevpro.bicitracker.viewmodel.MapViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val uiModule = module {

    viewModel {
        MapViewModel(
            observeCurrentLocation = get()
        )
    }
}

val domainModule = module {
    single {
        ObserveCurrentLocation(
            locationRepository = get(),
            coroutineDispatcher = get()
        )
    }

    single {
        AppCoroutineDispatchers(
            io = Dispatchers.IO,
            computation = Dispatchers.Default,
            main = Dispatchers.Main
        )
    }
}

val dataModule = module {
    single {
        DefaultLocationRepository(
            factory = get()
        ) as LocationRepository
    }

    single {
        LocationDataStoreFactory(
            cache = get(),
            remote = get(),
            device = get()
        )
    }
}

val dataRemoteModule = module {
    single {
        DefaultLocationRemoteDataStore() as LocationRemoteDataStore
    }
}

val dataCacheModule = module {
    single {
        DefaultLocationCacheDataStore() as LocationCacheDataStore
    }
}

val dataDeviceModule = module {
    single {
        DefaultLocationDeviceDataStore() as LocationDeviceDataStore
    }
}
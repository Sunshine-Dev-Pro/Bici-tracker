package com.sunshine.domain.interactor

import com.sunshine.domain.base.AppCoroutineDispatchers
import com.sunshine.domain.base.ResultInteractor
import com.sunshine.domain.model.Coord
import com.sunshine.domain.repository.LocationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first


class ObserveCurrentLocation(
    coroutineDispatcher: AppCoroutineDispatchers,
    private val locationRepository: LocationRepository
) : ResultInteractor<Unit, Coord>() {

    override val dispatcher: CoroutineDispatcher = coroutineDispatcher.io

//    override fun build(params: Unit): Flow<Coord> =
//        locationRepository.getLocationUpdates()
//            .map { it }

    override suspend fun doWork(params: Unit): Coord =
        locationRepository.getLocationUpdates().first()

}
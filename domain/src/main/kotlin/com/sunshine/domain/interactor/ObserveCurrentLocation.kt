package com.sunshine.domain.interactor

import com.sunshine.domain.base.AppCoroutineDispatcher
import com.sunshine.domain.base.SubjectInteractor
import com.sunshine.domain.model.Coord
import com.sunshine.domain.repository.LocationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow


class ObserveCurrentLocation(
    private val locationRepository: LocationRepository,
    coroutineDispatcher: AppCoroutineDispatcher
) : SubjectInteractor<Unit, Coord>() {

    override val dispatcher: CoroutineDispatcher = coroutineDispatcher.dispatcher

    override fun createObservable(params: Unit): Flow<Coord> =
        locationRepository.getLocationUpdates()
}
package com.sunshinedevpro.bicitracker.viewmodel

import androidx.lifecycle.ViewModel
import com.sunshine.domain.interactor.ObserveCurrentLocation
import com.sunshine.domain.model.Coord
import kotlinx.coroutines.flow.Flow

class MapViewModel(
    private val observeCurrentLocation: ObserveCurrentLocation
) : ViewModel() {

    val currentLocation: Flow<Coord>
        get() = observeCurrentLocation.observe()
}
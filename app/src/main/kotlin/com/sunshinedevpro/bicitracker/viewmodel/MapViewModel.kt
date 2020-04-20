package com.sunshinedevpro.bicitracker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sunshine.domain.interactor.ObserveCurrentLocation
import kotlinx.coroutines.launch

class MapViewModel(
    private val observeCurrentLocation: ObserveCurrentLocation
) : ViewModel() {

    init {
//        viewModelScope.launchObserve(observeCurrentLocation) { flow ->
//            flow.collect { it }
//        }

        viewModelScope.launch {
            val observeCurrentLocation1 = observeCurrentLocation(Unit)
            val i = 0
        }
    }

//    val currentLocation: Flow<Coord>
//        get() = observeCurrentLocation.observe()

}
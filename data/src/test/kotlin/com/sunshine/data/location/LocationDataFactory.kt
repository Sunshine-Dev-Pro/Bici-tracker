package com.sunshine.data.location

import com.sunshine.data.base.DataDataFactory
import com.sunshine.data.model.CoordEntity


object LocationDataFactory {

    fun makeGeoLocation() = CoordEntity(
        longitude = DataDataFactory.randomDouble(),
        latitude = DataDataFactory.randomDouble()
    )
}
package com.sunshime.domainTest.location

import com.sunshime.domainTest.base.DomainDataFactory
import com.sunshine.domain.model.Coord


object LocationDomainFactory {

    fun makeGeoLocation() = Coord(
        longitude = DomainDataFactory.randomDouble(),
        latitude = DomainDataFactory.randomDouble()
    )
}
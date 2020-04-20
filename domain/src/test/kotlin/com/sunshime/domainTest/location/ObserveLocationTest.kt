package com.sunshime.domainTest.location

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
import com.sunshine.domain.interactor.ObserveCurrentLocation
import com.sunshine.domain.model.Coord
import com.sunshine.domain.repository.LocationRepository
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals


@RunWith(MockitoJUnitRunner::class)
class ObserveLocationTest {

    @Mock
    private lateinit var locationRepository: LocationRepository

    private lateinit var observeCurrentLocation: ObserveCurrentLocation

    @Before
    fun setup() {
        observeCurrentLocation = ObserveCurrentLocation(
            locationRepository = locationRepository,
            coroutineDispatcher = mock()
        )
    }

    @Test
    fun `observe current location when is called and success`() = runBlockingTest {

        val coordinates = listOf(
            LocationDomainFactory.makeGeoLocation(),
            LocationDomainFactory.makeGeoLocation()
        )

        locationRepository.stub {
            onBlocking { it.getLocationUpdates() } doReturn coordinates.asFlow()
        }

        observeCurrentLocation.build(Unit).collectIndexed { index, value ->
            when (index) {
                0 -> assertEquals(coordinates.first(), value)
                1 -> assertEquals(coordinates.last(), value)
            }
        }
    }

    @Test
    fun `observe current location when is called and no receive values`() = runBlockingTest {

        val coordinates = emptyList<Coord>()

        locationRepository.stub {
            onBlocking { it.getLocationUpdates() } doReturn coordinates.asFlow()
        }

        observeCurrentLocation.build(Unit).test(this)
            .assertNoValues()
    }
}
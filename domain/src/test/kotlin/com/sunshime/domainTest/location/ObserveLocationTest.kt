package com.sunshime.domainTest.location

import com.nhaarman.mockitokotlin2.mock
import com.sunshime.domainTest.base.test
import com.sunshine.domain.interactor.ObserveCurrentLocation
import com.sunshine.domain.model.Coord
import com.sunshine.domain.repository.LocationRepository
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


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

        val result = LocationFactory.makeGeoLocation()

        val subject = ConflatedBroadcastChannel<Coord>()

        val observer = subject.asFlow().test(this)

        observer.assertNoValues()

        subject.send(result)

        observer.assertValues(result)

        observer.finish()
    }

    @Test
    fun `observe current location when is called and no receive values`() = runBlockingTest {

        val subject = ConflatedBroadcastChannel<Coord>()

        val observer = subject.asFlow().test(this)

        observer.assertNoValues()

        observer.assertValues()

        observer.finish()
    }
}
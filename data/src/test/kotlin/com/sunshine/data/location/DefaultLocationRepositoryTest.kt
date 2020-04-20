package com.sunshine.data.location

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
import com.sunshine.data.base.test
import com.sunshine.data.extension.toDomain
import com.sunshine.data.model.CoordEntity
import com.sunshine.data.repository.DefaultLocationRepository
import com.sunshine.data.store.LocationDataStoreFactory
import com.sunshine.domain.repository.LocationRepository
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertEquals

@RunWith(MockitoJUnitRunner::class)
class DefaultLocationRepositoryTest {

    @Mock
    private lateinit var factory: LocationDataStoreFactory

    private lateinit var repository: LocationRepository

    @Before
    fun setUp() {

        factory = LocationDataStoreFactory(
            cache = mock(),
            remote = mock(),
            device = mock()
        )

        repository = DefaultLocationRepository(
            factory = factory
        )
    }

    @Test
    fun `observe current location when is called and success`() = runBlockingTest {

        val data = listOf(
            LocationDataFactory.makeGeoLocation(),
            LocationDataFactory.makeGeoLocation()
        )

        val result = data.map(CoordEntity::toDomain)

        factory.device.stub {
            onBlocking { it.getLocationUpdates(UPDATE_LOCATION_INTERVAL) } doReturn data.asFlow()
        }

        repository.getLocationUpdates().collectIndexed { index, value ->
            when (index) {
                0 -> assertEquals(result.first(), value)
                1 -> assertEquals(result.last(), value)
            }
        }
    }

    @Test
    fun `observe current location when is called and return empty data`() = runBlockingTest {

        val data = emptyList<CoordEntity>()

        factory.device.stub {
            onBlocking { it.getLocationUpdates(UPDATE_LOCATION_INTERVAL) } doReturn data.asFlow()
        }

        repository.getLocationUpdates().test(this)
            .assertNoValues()
    }

    private companion object {
        const val UPDATE_LOCATION_INTERVAL = 1000L
    }
}
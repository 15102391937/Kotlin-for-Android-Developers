package com.antonioleiva.weatherapp.domain.datasource

import com.antonioleiva.weatherapp.domain.model.DoForecast
import com.antonioleiva.weatherapp.domain.model.DoForecastList
import org.junit.Assert.assertNotNull
import org.junit.Test
import org.mockito.Mockito.*

class SeDoForecastProviderTest {

    @Test
    fun `data source returns a value`() {
        val ds = mock(ForecastDataSource::class.java)
        `when`(ds.requestDayForecast(0)).then { DoForecast(0, 0, "desc", 20, 0, "url") }

        val provider = ForecastProvider(listOf(ds))
        assertNotNull(provider.requestForecast(0))
    }

    @Test
    fun `empty database returns server value`() {
        val db = mock(ForecastDataSource::class.java)
        val server = mock(ForecastDataSource::class.java)
        `when`(server.requestForecastByZipCode(any(Long::class.java), any(Long::class.java)))
                .then { DoForecastList(0, "city", "country", listOf()) }

        val provider = ForecastProvider(listOf(db, server))
        assertNotNull(provider.requestByZipCode(0, 0))
    }

}
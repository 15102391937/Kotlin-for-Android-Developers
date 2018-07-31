package com.antonioleiva.weatherapp.domain.datasource

import com.antonioleiva.weatherapp.domain.model.DoForecast
import com.antonioleiva.weatherapp.domain.model.DoForecastList

interface ForecastDataSource {

    fun requestForecastByZipCode(zipCode: Long, date: Long): DoForecastList?

    fun requestDayForecast(id: Long): DoForecast?

}
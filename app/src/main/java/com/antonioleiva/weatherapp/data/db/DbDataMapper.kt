package com.antonioleiva.weatherapp.data.db

import com.antonioleiva.weatherapp.domain.model.DoForecast
import com.antonioleiva.weatherapp.domain.model.DoForecastList

class DbDataMapper {

    fun convertFromDomain(doForecast: DoForecastList) = with(doForecast) {
        val daily = dailyDoForecast.map { convertDayFromDomain(id, it) }
        DBCityForecast(id, city, country, daily)
    }

    private fun convertDayFromDomain(cityId: Long, doForecast: DoForecast) = with(doForecast) {
        DBDayForecast(date, description, high, low, iconUrl, cityId)
    }

    fun convertToDomain(forecastDB: DBCityForecast) = with(forecastDB) {
        val daily = dailyForecastDB.map { convertDayToDomain(it) }
        DoForecastList(_id, city, country, daily)
    }

    fun convertDayToDomain(DBDayForecast: DBDayForecast) = with(DBDayForecast) {
        DoForecast(_id, date, description, high, low, iconUrl)
    }
}
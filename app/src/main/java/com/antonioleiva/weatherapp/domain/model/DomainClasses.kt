package com.antonioleiva.weatherapp.domain.model

data class DoForecastList(val id: Long, val city: String, val country: String,
                          val dailyDoForecast: List<DoForecast>) {

    val size: Int
        get() = dailyDoForecast.size

    operator fun get(position: Int) = dailyDoForecast[position]
}

data class DoForecast(val id: Long, val date: Long, val description: String, val high: Int, val low: Int,
                      val iconUrl: String)
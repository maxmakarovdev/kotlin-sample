package ru.makarov.kotlin.example.data

/**
 * @author Maxim Makarov
 * @since 12.08.2017
 */
data class ForecastList(val city: String, val country: String, val dailyForecast: List<Forecast>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int): Forecast = dailyForecast[position]
}

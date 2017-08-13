package ru.makarov.kotlin.example.command

import ru.makarov.kotlin.example.data.ForecastList
import ru.makarov.kotlin.example.data.provider.ForecastProvider

/**
 * @author Maxim Makarov
 * @since 12.08.2017
 */
class RequestForecastCommand(val zipCode: Long, val forecastProvider: ForecastProvider = ForecastProvider()) :
        Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute(): ForecastList {
        return forecastProvider.requestByZipCode(zipCode, DAYS)
    }
}

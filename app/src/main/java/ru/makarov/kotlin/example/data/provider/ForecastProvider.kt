package ru.makarov.kotlin.example.data.provider

import ru.makarov.kotlin.example.data.ForecastList
import ru.makarov.kotlin.example.network.Request
import ru.makarov.kotlin.example.network.ServerDataMapper

/**
 * @author Maxim Makarov
 * *
 * @since 13.08.2017
 */
interface ForecastDataSource {
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList
}

class ForecastServer(val dataMapper: ServerDataMapper = ServerDataMapper()) : ForecastDataSource {

    override fun requestForecastByZipCode(zipCode: Long, date: Long):
            ForecastList {
        val result = Request(zipCode).execute()
        return dataMapper.convertToDomain(zipCode, result)
    }
}


class ForecastProvider(val source: ForecastDataSource = ForecastProvider.SOURCE) {

    companion object {
        val DAY_IN_MILLIS = 1000 * 60 * 60 * 24
        val SOURCE = ForecastServer()
    }

    fun requestByZipCode(zipCode: Long, days: Int): ForecastList = requestSource(source, days, zipCode)

    fun requestSource(source: ForecastDataSource, days: Int, zipCode: Long): ForecastList {
        return source.requestForecastByZipCode(zipCode, todayTimeSpan())
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DAY_IN_MILLIS * DAY_IN_MILLIS
}


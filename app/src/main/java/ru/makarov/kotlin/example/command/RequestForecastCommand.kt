package ru.makarov.kotlin.example.command

import ru.makarov.kotlin.example.data.mapper.ForecastDataMapper
import ru.makarov.kotlin.example.data.ForecastList
import ru.makarov.kotlin.example.network.Request

/**
 * @author Maxim Makarov
 * @since 12.08.2017
 */
class RequestForecastCommand(private val zipCode: String) : Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = Request(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}

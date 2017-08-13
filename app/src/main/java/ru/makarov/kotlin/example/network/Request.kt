package ru.makarov.kotlin.example.network

import com.google.gson.Gson
import java.net.URL

/**
 * @author Maxim Makarov
 * @since 12.08.2017
 */
class Request(val zipCode: Long, val gson: Gson = Gson()) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="

        private val DARK_SKY_API_KEY = "0ca6beda434ef1605b8b317ec04b6ee6"
        private val LATITUDE = "55.036"
        private val LONGITUDE = "82.913"
        private val REQUEST_URL = "https://api.darksky.net/forecast/$DARK_SKY_API_KEY/$LATITUDE,$LONGITUDE?lang=ru&units=si"
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return gson.fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}
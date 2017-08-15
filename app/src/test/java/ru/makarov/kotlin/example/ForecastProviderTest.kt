package ru.makarov.kotlin.example

import org.junit.Assert.*
import org.junit.Test
import ru.makarov.kotlin.example.data.Forecast
import ru.makarov.kotlin.example.data.provider.ForecastDataSource
import ru.makarov.kotlin.example.data.provider.ForecastProvider
import org.mockito.Mockito.`when` as whenever
import org.mockito.Mockito.mock

/**
 * @author Maxim Makarov
 * @since 15.08.2017
 */
class ForecastProviderTest {
    @Test fun testDataSourceReturnsValue() {
        val ds = mock(ForecastDataSource::class.java)
        whenever(ds.requestForecastByZipCode(94043, 0)).then {
            Forecast("Oct 19 2015", "desc", 20, 0, "url")
        }

        val provider = ForecastProvider(ds)
        assertNotNull(provider.requestByZipCode(94043, 0))
    }
}
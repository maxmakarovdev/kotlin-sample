package ru.makarov.kotlin.example

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.makarov.kotlin.example.core.utils.toDateString
import java.text.DateFormat

/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test fun simpleUnitTest() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test fun testLongToDateString() {
        assertEquals("Oct 19, 2015", 1445275635000L.toDateString())
    }

    @Test fun testDateStringFullFormat() {
        assertEquals("Monday, October 19, 2015", 1445275635000L.toDateString(DateFormat.FULL))
    }
}
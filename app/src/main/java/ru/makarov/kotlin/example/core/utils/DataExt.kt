package ru.makarov.kotlin.example.core.utils

import java.text.DateFormat
import java.util.*

/**
 * @author Maxim Makarov
 * @since 15.08.2017
 */
fun Long.toDateString(dateFormat: Int = DateFormat.MEDIUM): String {
    val df = DateFormat.getDateInstance(dateFormat, Locale.US)
    return df.format(this)
}
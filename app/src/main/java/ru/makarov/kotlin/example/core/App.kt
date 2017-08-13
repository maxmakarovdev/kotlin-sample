package ru.makarov.kotlin.example.core

import android.app.Application
import ru.makarov.kotlin.example.core.utils.DelegatesExt

/**
 * @author Maxim Makarov
 * @since 13.08.2017
 */
class App : Application() {

    companion object {
        var instance: App by DelegatesExt.notNullSingleValue()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}

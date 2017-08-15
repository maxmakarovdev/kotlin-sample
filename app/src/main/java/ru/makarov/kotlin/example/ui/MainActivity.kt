package ru.makarov.kotlin.example.ui

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.asReference
import org.jetbrains.anko.coroutines.experimental.bg
import ru.makarov.kotlin.example.R
import ru.makarov.kotlin.example.command.RequestForecastCommand
import ru.makarov.kotlin.example.data.ForecastList

class MainActivity : AppCompatActivity() {

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

    inline fun <reified T : Activity> Context.startActivity(vararg params: Pair<String, String>) {
        val intent = Intent(this, T::class.java)
        params.forEach { intent.putExtra(it.first, it.second) }
        startActivity(intent)
    }

    fun View.slideExit() {
        if (translationY == 0f) animate().translationY(-height.toFloat())
    }

    fun View.slideEnter() {
        if (translationY < 0f) animate().translationY(0f)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecastList.layoutManager = LinearLayoutManager(this)
        loadForecast()
    }

    fun loadForecast() {
        val ref = asReference()
        async(UI) {
            val result = bg { RequestForecastCommand(94043).execute() }
            val weekForecast = result.await()
            ref().updateUI(weekForecast)
        }
    }

    fun updateUI(forecast: ForecastList) {
        forecastList.adapter = ListAdapter(forecast, { toast(it.description) })
    }
}

package ru.makarov.kotlin.example.ui.utils

import android.content.Context
import android.view.View

/**
 * @author Maxim Makarov
 * @since 13.08.2017
 */
val View.ctx: Context
    get() = context

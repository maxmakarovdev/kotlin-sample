package ru.makarov.kotlin.example.command

/**
 * @author Maxim Makarov
 * @since 12.08.2017
 */
interface Command<out T> {
    fun execute(): T
}
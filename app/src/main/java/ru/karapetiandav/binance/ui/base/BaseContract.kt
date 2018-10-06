package ru.karapetiandav.binance.ui.base


class BaseContract {

    interface Presenter<T> {
        val view: T?
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View<T> {
        val presenter: T
    }
}
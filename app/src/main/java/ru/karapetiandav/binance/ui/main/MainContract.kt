package ru.karapetiandav.binance.ui.main

import ru.karapetiandav.binance.ui.base.BaseContract


class MainContract {

    interface Presenter : BaseContract.Presenter<View>

    interface View : BaseContract.View<Presenter> {
        fun showListFragment()
    }
}
package ru.karapetiandav.binance.ui.list

import ru.karapetiandav.binance.models.Symbol
import ru.karapetiandav.binance.ui.base.BaseContract


class SymbolsListContract {

    interface View : BaseContract.View<Presenter> {
        fun showProgress(show: Boolean)
        fun showErrorMessage(error: String)
        fun loadDataSuccess(symbols: Array<Symbol>)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun loadData()
    }
}
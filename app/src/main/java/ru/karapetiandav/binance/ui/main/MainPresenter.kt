package ru.karapetiandav.binance.ui.main


class MainPresenter : MainContract.Presenter {
    override lateinit var view: MainContract.View

    override fun subscribe() {
    }

    override fun unsubscribe() {
    }

    override fun attach(view: MainContract.View) {
        this.view = view
    }
}
package ru.karapetiandav.binance.ui.list

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import ru.karapetiandav.binance.api.ApiService


class SymbolsListPresenter : SymbolsListContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private val api = ApiService.create()
    override var view: SymbolsListContract.View? = null

    override fun loadData() {
        view?.showProgress(true)
        val subscribe = api.getExchangeInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    view?.loadDataSuccess(it.symbols)
                }, {
                    view?.showErrorMessage(it.localizedMessage)
                })

        subscriptions.add(subscribe)
        view?.showProgress(false)
    }

    override fun subscribe() {}

    override fun unsubscribe() {
        subscriptions.clear()
        view = null
    }

    override fun attach(view: SymbolsListContract.View) {
        this.view = view
    }

}
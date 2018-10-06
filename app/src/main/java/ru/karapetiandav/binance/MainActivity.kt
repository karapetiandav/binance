package ru.karapetiandav.binance

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.karapetiandav.binance.api.ApiServer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val subscribe = ApiServer.create().getExchangeInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { exchangeInfo, error ->
                    Log.d(this::class.java.simpleName, exchangeInfo.symbols[0].status)
                }
    }
}

package ru.karapetiandav.binance.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.karapetiandav.binance.R
import ru.karapetiandav.binance.ui.list.SymbolsListFragment

class MainActivity : AppCompatActivity(), MainContract.View {

    override val presenter: MainContract.Presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attach(this)
        showListFragment()
    }

    override fun showListFragment() {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.container, SymbolsListFragment())
                .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }
}

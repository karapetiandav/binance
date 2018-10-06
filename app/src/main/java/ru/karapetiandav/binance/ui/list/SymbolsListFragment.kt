package ru.karapetiandav.binance.ui.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_symbols.*
import ru.karapetiandav.binance.R
import ru.karapetiandav.binance.models.Symbol

class SymbolsListFragment : Fragment(), SymbolsListContract.View {

    override val presenter: SymbolsListContract.Presenter = SymbolsListPresenter()

    private lateinit var adapter: SymbolsListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter.attach(this)
        return inflater.inflate(R.layout.fragment_symbols, container, false)
    }

    override fun onStart() {
        super.onStart()
        presenter.loadData()
    }

    override fun loadDataSuccess(symbols: Array<Symbol>) {
        adapter = SymbolsListAdapter(symbols)
        val layoutManager = LinearLayoutManager(activity)
        val decoration = DividerItemDecoration(context, layoutManager.orientation)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(decoration)
    }

    override fun showErrorMessage(error: String) {
        Toast.makeText(activity, error, Toast.LENGTH_LONG).show()
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progress.visibility = VISIBLE
        } else {
            progress.visibility = GONE
        }
    }

}

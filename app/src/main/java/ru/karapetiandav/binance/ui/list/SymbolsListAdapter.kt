package ru.karapetiandav.binance.ui.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_symbol.view.*
import ru.karapetiandav.binance.R
import ru.karapetiandav.binance.models.Symbol


class SymbolsListAdapter(private val symbols: Array<Symbol>, private val clickListener: View.OnClickListener? = null) : RecyclerView.Adapter<SymbolsListAdapter.SymbolViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): SymbolViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_symbol, viewGroup, false)
        return SymbolViewHolder(view)
    }

    override fun getItemCount(): Int = symbols.size

    override fun onBindViewHolder(viewHolder: SymbolViewHolder, position: Int) {
        viewHolder.bind(symbols[position], clickListener)
    }

    class SymbolViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(symbol: Symbol, click: View.OnClickListener? = null) {
            itemView.name.text = symbol.symbol
            itemView.status.text = symbol.status
            itemView.setOnClickListener(click)
        }
    }
}
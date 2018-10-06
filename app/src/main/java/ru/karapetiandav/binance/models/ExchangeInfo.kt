package ru.karapetiandav.binance.models

import java.util.Arrays

data class ExchangeInfo(val symbols: Array<Symbol>) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ExchangeInfo

        if (!Arrays.equals(symbols, other.symbols)) return false

        return true
    }

    override fun hashCode(): Int {
        return Arrays.hashCode(symbols)
    }
}
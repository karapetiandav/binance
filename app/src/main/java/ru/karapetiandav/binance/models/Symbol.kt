package ru.karapetiandav.binance.models

data class Symbol(val symbol: String,
                  val status: String,
                  val baseAsset: String,
                  val baseAssetPrecision: Int,
                  val quoteAsset: String,
                  val quotePrecision: Int)
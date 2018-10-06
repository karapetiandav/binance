package ru.karapetiandav.binance.api

import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import ru.karapetiandav.binance.models.ExchangeInfo


interface ApiService {
    @GET("exchangeInfo")
    fun getExchangeInfo(): Single<ExchangeInfo>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.binance.com/api/v1/")
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
package com.crypto.app.data.remote

import com.crypto.app.data.remote.dto.CoinDetailDto
import com.crypto.app.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApi
{
    @GET("v1/coins")
    suspend fun getCoins() : List<CoinDto>

    @GET("v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coin : String) : CoinDetailDto
}
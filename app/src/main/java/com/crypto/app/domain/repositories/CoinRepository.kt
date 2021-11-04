package com.crypto.app.domain.repositories

import com.crypto.app.data.remote.dto.CoinDetailDto
import com.crypto.app.data.remote.dto.CoinDto

interface CoinRepository
{
    suspend fun getCoins() : List<CoinDto>

    suspend fun getCoinById(coinId: String) : CoinDetailDto
}
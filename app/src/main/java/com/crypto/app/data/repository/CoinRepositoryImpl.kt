package com.crypto.app.data.repository

import com.crypto.app.data.remote.CoinPaprikaApi
import com.crypto.app.data.remote.dto.CoinDetailDto
import com.crypto.app.data.remote.dto.CoinDto
import com.crypto.app.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val paprikaApi: CoinPaprikaApi
) : CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return paprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return paprikaApi.getCoinById(coin = coinId)
    }
}
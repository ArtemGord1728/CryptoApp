package com.crypto.app.domain.use_case.get_coin

import com.crypto.app.common.Resource
import com.crypto.app.data.remote.CoinPaprikaApi
import com.crypto.app.data.remote.dto.toCoin
import com.crypto.app.domain.model.Coin
import com.crypto.app.domain.model.CoinDetail
import com.crypto.app.domain.model.toCoinDetail
import com.crypto.app.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        } catch (error: HttpException) {
            emit(Resource.Error<CoinDetail>(error.localizedMessage ?: "Unexpected error"))
        } catch (error: IOException) {
            emit(Resource.Error<CoinDetail>("Couldn't reach server. Check your internet connection!"))
        }
    }
}
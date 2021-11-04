package com.crypto.app.domain.use_case.get_coins

import com.crypto.app.common.Resource
import com.crypto.app.data.remote.dto.toCoin
import com.crypto.app.domain.model.Coin
import com.crypto.app.domain.repositories.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        } catch (error: HttpException) {
            emit(Resource.Error<List<Coin>>(error.localizedMessage ?: "Unexpected error"))
        } catch (error: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection!"))
        }
    }
}
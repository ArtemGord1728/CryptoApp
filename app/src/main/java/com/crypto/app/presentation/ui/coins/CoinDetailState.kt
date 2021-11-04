package com.crypto.app.presentation.ui.coins

import com.crypto.app.domain.model.Coin
import com.crypto.app.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
) {

}
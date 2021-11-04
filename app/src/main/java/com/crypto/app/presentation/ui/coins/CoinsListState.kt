package com.crypto.app.presentation.ui.coins

import com.crypto.app.domain.model.Coin

data class CoinsListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
) {

}
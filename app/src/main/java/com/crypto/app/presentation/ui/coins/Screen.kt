package com.crypto.app.presentation.ui.coins

sealed class Screen(val route: String) {
    object CoinListScreen : Screen("coin_list_activity")
    object CoinDetailScreen : Screen("coin_detail_activity")
}

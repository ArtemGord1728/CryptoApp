package com.crypto.app.presentation.ui.coins

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Transformations.map
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.crypto.app.common.Resource
import com.crypto.app.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
)  : ViewModel() {
    private val _state = mutableStateOf(CoinsListState())
    val state: State<CoinsListState> get() = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinsListState(coins = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CoinsListState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value = CoinsListState(error = result.message ?: "unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }
}
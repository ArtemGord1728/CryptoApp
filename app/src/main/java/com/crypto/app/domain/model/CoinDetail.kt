package com.crypto.app.domain.model

import com.crypto.app.data.remote.dto.CoinDetailDto
import com.crypto.app.data.remote.dto.CoinDto
import com.crypto.app.data.remote.dto.TeamMember

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>,
)

fun CoinDetailDto.toCoinDetail() : CoinDetail {
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank = rank,
        isActive = is_active,
        tags = tags.map { it.name },
        team = team
    )
}
package com.moontomi.server.core.season

import com.moontomi.server.core.image.ImageCreationRequest
import com.moontomi.server.core.image.ImageDto

data class SeasonDto (
    val id: Int,
    val name: String,
    val image: ImageDto
) {
    companion object {
        fun from(season: Season): SeasonDto = SeasonDto (
            id = season.id!!,
            name = season.name,
            image = ImageDto.from(season.image)
        )
    }
}

data class SeasonCreationRequest (
    val name: String,
    val image: ImageCreationRequest
) {
    fun to(): Season = Season(
        id = null,
        name = name,
        image = image.to()
    )
}
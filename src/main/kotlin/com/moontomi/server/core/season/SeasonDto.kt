package com.moontomi.server.core.season

import com.moontomi.server.core.image.ImageCreationRequest
import com.moontomi.server.core.image.ImageDto

data class SeasonDto (
    val name: String,
    val imageId: Int
) {
    companion object {
        fun from(season: Season): SeasonDto = SeasonDto (
            name = season.name,
            imageId = season.imageId
        )
    }

    fun to(): Season = Season(
        name = name,
        imageId = imageId
    )
}

data class SeasonCreationRequest (
    val name: String,
    val imageId: Int
) {
    fun to(): Season = Season(
        name = name,
        imageId = imageId
    )
}
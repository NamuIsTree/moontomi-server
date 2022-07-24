package com.moontomi.server.core.genre

data class GenreDto (
    val id: Int,
    val category: GenreCategory,
    val name: String
) {
    companion object {
        fun from(genre: Genre): GenreDto = GenreDto(
            id = genre.id!!,
            category = genre.category,
            name = genre.name
        )
    }

    fun to(): Genre = Genre (
        id = id,
        category = category,
        name = name
    )
}

data class GenreCreationRequest (
    val category: GenreCategory,
    val name: String
) {
    fun to(): Genre = Genre(
        id = null,
        category = category,
        name = name
    )
}
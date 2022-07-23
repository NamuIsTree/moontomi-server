package com.moontomi.server.core.artist

data class ArtistDto (
    val id: Int,
    val name: String,
    val nation: String
) {
    companion object {
        fun from(artist: Artist): ArtistDto = ArtistDto(
            id = artist.id!!,
            name = artist.name,
            nation = artist.nation
        )
    }

    fun to(): Artist = Artist(
        id = id,
        name = name,
        nation = nation
    )
}

data class ArtistCreationRequest (
    val name: String,
    val nation: String
) {
    fun to(): Artist = Artist(
        id = null,
        name = name,
        nation = nation
    )
}
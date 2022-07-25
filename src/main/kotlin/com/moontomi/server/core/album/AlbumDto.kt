package com.moontomi.server.core.album

import com.moontomi.server.core.artist.ArtistDto
import com.moontomi.server.core.genre.GenreDto
import com.moontomi.server.core.season.SeasonDto
import java.time.LocalDateTime

data class AlbumDto (
    val id: Int,
    val artist: ArtistDto,
    val imageId: Int,
    val season: SeasonDto,
    val genres: List<GenreDto>,
    val tracks: List<String>,
    val release: LocalDateTime
) {
    companion object {
        fun from(album: Album, season: SeasonDto, genres: List<GenreDto>): AlbumDto = AlbumDto(
            id = album.id!!,
            artist = ArtistDto.from(album.artist),
            imageId = album.imageId,
            season = season,
            genres = genres,
            tracks = album.tracks,
            release = album.release
        )
    }

    fun to(genres: List<GenreDto>): Album = Album(
        id = id,
        artist = artist.to(),
        imageId = imageId,
        season =  season.name,
        genres = genres.map { it.id},
        tracks = tracks,
        release = release
    )
}

data class AlbumCreationRequest (
    val artistId: Int,
    val imageId: Int,
    val season: String,
    val genreIds: List<Int>,
    val tracks: List<String>,
    val release: LocalDateTime
) {
    fun to(artist: ArtistDto, season: SeasonDto, genres: List<GenreDto>): Album = Album(
        id = null,
        artist = artist.to(),
        imageId = imageId,
        season = season.name,
        genres = genres.map { it.id },
        tracks = tracks,
        release = release
    )
}
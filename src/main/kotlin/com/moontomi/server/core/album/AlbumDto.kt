package com.moontomi.server.core.album

import com.moontomi.server.core.artist.ArtistDto
import com.moontomi.server.core.genre.GenreDto
import java.time.LocalDateTime

data class AlbumDto (
    val id: Int,
    val title: String,
    val artist: ArtistDto,
    val imageId: Int,
    val genres: List<GenreDto>,
    val tracks: List<String>,
    val release: LocalDateTime
) {
    companion object {
        fun from(album: Album, genres: List<GenreDto>): AlbumDto = AlbumDto(
            id = album.id!!,
            title = album.title,
            artist = ArtistDto.from(album.artist),
            imageId = album.imageId,
            genres = genres,
            tracks = album.tracks,
            release = album.release
        )
    }

    fun to(): Album = Album(
        id = id,
        title = title,
        artist = artist.to(),
        imageId = imageId,
        genres = genres.map { it.id },
        tracks = tracks,
        release = release
    )
}

data class AlbumCreationRequest (
    val title: String,
    val artistId: Int,
    val imageId: Int,
    val genreIds: List<Int>,
    val tracks: List<String>,
    val release: LocalDateTime
) {
    fun to(artist: ArtistDto, genres: List<GenreDto>): Album = Album(
        id = null,
        title = title,
        artist = artist.to(),
        imageId = imageId,
        genres = genres.map { it.id },
        tracks = tracks,
        release = release
    )
}
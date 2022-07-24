package com.moontomi.server.core.album

import com.moontomi.server.core.artist.ArtistDto
import com.moontomi.server.core.image.ImageDto
import java.time.LocalDateTime

data class AlbumDto (
    val id: Int,
    val artist: ArtistDto,
    val image: ImageDto,
    val tracks: Tracks,
    val release: LocalDateTime
) {
    companion object {
        fun from(album: Album): AlbumDto = AlbumDto(
            id = album.id,
            artist = ArtistDto.from(album.artist),
            image = ImageDto.from(album.image),
            tracks = album.tracks,
            release = album.release
        )
    }
}
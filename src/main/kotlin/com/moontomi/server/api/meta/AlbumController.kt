package com.moontomi.server.api.meta

import com.moontomi.server.core.album.AlbumCreationRequest
import com.moontomi.server.core.album.AlbumDto
import com.moontomi.server.core.album.AlbumService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import java.time.LocalDateTime

@RestController
class AlbumController(
    private val albumService: AlbumService
) : AbstractMetaController() {
    @GetMapping("/albums.v1")
    fun getAlbums(): List<AlbumDto> {
        return albumService.findAll()
    }

    @GetMapping("/album/{albumId}.v1")
    fun getAlbum(@PathVariable albumId: Int): AlbumDto {
        return albumService.findById(albumId)
    }

    @PostMapping("/album.v1")
    fun postAlbum(@RequestBody request: AlbumCreationRequest): AlbumDto {
        return albumService.insert(request)
    }

    @PutMapping("/album/{albumId}.v1")
    fun putAlbum(@PathVariable albumId: Int, @RequestBody request: AlbumChangeRequest) {
        // TODO
    }
}

data class AlbumChangeRequest(
    val artistId: Int?,
    val image: MultipartFile?,
    val genres: List<Int>?,
    val tracks: List<String>?,
    val release: LocalDateTime?
)
package com.moontomi.server.api.meta

import com.moontomi.server.core.album.AlbumService
import com.moontomi.server.core.image.ImageCreationRequest
import com.moontomi.server.core.image.ImageDto
import com.moontomi.server.core.image.ImageService
import com.moontomi.server.core.season.SeasonService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile

@RestController
class ImageController(
    private val imageService: ImageService,
    private val seasonService: SeasonService,
    private val albumService: AlbumService
) : AbstractMetaController() {
    @GetMapping(
        value = ["/image/season/{seasonName}.v1"],
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    fun getSeasonImage(@PathVariable seasonName: String): ByteArray {
        val season = seasonService.findById(seasonName)
        return imageService.findById(season.imageId).data
    }

    @GetMapping(
        value = ["/image/album/{albumId}.v1"],
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    fun getAlbumImage(@PathVariable albumId: Int): ByteArray {
        val album = albumService.findById(albumId)
        return imageService.findById(album.imageId).data
    }

    @PostMapping("/image.v1")
    fun postImage(@RequestParam("data") data: MultipartFile): ImageDto {
        return imageService.insert(
            request = ImageCreationRequest(data.bytes)
        )
    }
}
package com.moontomi.server.api.meta

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
    private val seasonService: SeasonService
) : AbstractMetaController() {
    @GetMapping(
        value = ["/image/{imageId}.v1"],
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    fun getImage(@PathVariable imageId: Int): ByteArray {
        val image = imageService.findById(imageId)
        return image.data
    }

    @GetMapping(
        value = ["/image/season/{seasonName}.v1"],
        produces = [MediaType.IMAGE_JPEG_VALUE]
    )
    fun getSeasonImage(@PathVariable seasonName: String): ByteArray {
        val season = seasonService.findById(seasonName)
        return imageService.findById(season.imageId).data
    }

    @PostMapping("/image.v1")
    fun postImage(@RequestParam("data") data: MultipartFile): ImageDto {
        return imageService.insert(
            request = ImageCreationRequest(data.bytes)
        )
    }
}
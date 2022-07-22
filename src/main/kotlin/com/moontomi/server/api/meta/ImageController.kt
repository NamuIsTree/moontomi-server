package com.moontomi.server.api.meta

import com.moontomi.server.core.image.ImageService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/image")
class ImageController(
    private val imageService: ImageService
) : AbstractMetaController() {
}
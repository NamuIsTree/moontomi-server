package com.moontomi.server.api.meta

import com.moontomi.server.core.artist.ArtistService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/artist")
class ArtistController(
    private val artistService: ArtistService
) : AbstractMetaController() {
}
package com.moontomi.server.api.meta

import com.moontomi.server.core.album.AlbumService
import com.moontomi.server.core.season.SeasonService
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/album")
class AlbumController(
    private val albumService: AlbumService,
    private val seasonService: SeasonService
) : AbstractMetaController() {
}
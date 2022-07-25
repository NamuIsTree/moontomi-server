package com.moontomi.server.api.meta

import com.moontomi.server.core.season.SeasonCreationRequest
import com.moontomi.server.core.season.SeasonDto
import com.moontomi.server.core.season.SeasonService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class SeasonController (
    private val seasonService: SeasonService
) : AbstractMetaController() {
    @GetMapping("/seasons.v1")
    fun getSeasons(): List<SeasonDto> {
        return seasonService.findAll()
    }

    @PostMapping("/season.v1")
    fun postSeason(@RequestBody request: SeasonCreationRequest): SeasonDto {
        return seasonService.insert(request)
    }
}
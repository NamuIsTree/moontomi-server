package com.moontomi.server.core.season

import com.moontomi.server.core.image.ImageService
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SeasonService (
    private val seasonRepository: SeasonRepository,
    private val imageService: ImageService
) {
    fun findAll(): List<SeasonDto> {
        return seasonRepository.findAll().map { SeasonDto.from(it) }
    }

    fun findById(id: String): SeasonDto {
        return SeasonDto.from(
            seasonRepository.findByIdOrNull(id) ?: throw Exception("seasonId=$id does not exist.")
        )
    }

    fun insert(request: SeasonCreationRequest): SeasonDto {
        if (!imageService.existsById(request.imageId)) {
            throw Exception("imageId=${request.imageId} does not exist.")
        }

        return SeasonDto.from(
            seasonRepository.save(request.to())
        )
    }
}
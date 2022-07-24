package com.moontomi.server.core.season

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SeasonService (
    private val seasonRepository: SeasonRepository
) {
    fun findById(id: Int): SeasonDto {
        return SeasonDto.from(
            seasonRepository.findByIdOrNull(id) ?: throw Exception("seasonId=$id does not exist.")
        )
    }

    fun insert(request: SeasonCreationRequest): SeasonDto {
        return SeasonDto.from(
            seasonRepository.save(request.to())
        )
    }
}
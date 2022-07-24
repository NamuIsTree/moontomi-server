package com.moontomi.server.core.image

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ImageService (
    private val imageRepository: ImageRepository
){
    fun findById(id: Int): ImageDto {
        return ImageDto.from(
            imageRepository.findByIdOrNull(id) ?: throw Exception("imageId=$id does not exist.")
        )
    }

    fun insert(request: ImageCreationRequest): ImageDto {
        return ImageDto.from(
            imageRepository.save(request.to())
        )
    }

    fun update(image: ImageDto): ImageDto {
        return ImageDto.from(
            imageRepository.save(image.to())
        )
    }
}
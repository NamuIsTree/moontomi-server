package com.moontomi.server.core.image

class ImageDto(
    val id: Int,
    val data: ByteArray
) {
    companion object {
        fun from(image: Image): ImageDto = ImageDto(
            id = image.id!!,
            data = image.data
        )
    }

    fun to(): Image = Image(
        id = id,
        data = data
    )
}

class ImageCreationRequest(
    val data: ByteArray
) {
    fun to(): Image = Image(
        id = null,
        data = data
    )
}
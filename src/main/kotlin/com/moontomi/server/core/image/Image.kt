package com.moontomi.server.core.image

import javax.persistence.*

@Entity
@Table(name = "image")
class Image (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    val id: Int?,

    @Lob
    @Column(name = "image")
    val data: ByteArray
)
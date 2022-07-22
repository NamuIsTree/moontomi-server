package com.moontomi.server.core.image

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Lob
import javax.persistence.Table

@Entity
@Table(name = "image")
class Image (
    @Id
    @Column(name = "image_id")
    val id: Int,

    @Lob
    @Column(name = "image")
    val image: ByteArray
)
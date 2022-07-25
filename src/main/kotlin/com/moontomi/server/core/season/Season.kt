package com.moontomi.server.core.season

import com.moontomi.server.core.image.Image
import javax.persistence.*

@Entity
@Table(name = "season")
class Season (
    @Id
    @Column(name = "name")
    val name: String,

    @Column(name = "image_id")
    val imageId: Int
)
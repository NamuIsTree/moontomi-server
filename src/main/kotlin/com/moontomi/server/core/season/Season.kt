package com.moontomi.server.core.season

import com.moontomi.server.core.image.Image
import javax.persistence.*

@Entity
@Table(name = "season")
class Season (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "season_id")
    val id: Int?,

    @Column(name = "name")
    val name: String,

    @JoinColumn(name = "image_id")
    val image: Image
)
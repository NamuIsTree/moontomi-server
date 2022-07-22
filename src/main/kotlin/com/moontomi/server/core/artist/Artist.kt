package com.moontomi.server.core.artist

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "artist")
class Artist (
    @Id
    @Column(name = "artist_id")
    val id: Int,

    @Column(name = "name")
    val name: String,

    @Column(name = "nation")
    val nation: String
)

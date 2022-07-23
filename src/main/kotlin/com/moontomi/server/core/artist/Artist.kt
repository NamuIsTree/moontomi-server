package com.moontomi.server.core.artist

import javax.persistence.*

@Entity
@Table(name = "artist")
class Artist (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id")
    var id: Int?,

    @Column(name = "name")
    var name: String,

    @Column(name = "nation")
    var nation: String
)

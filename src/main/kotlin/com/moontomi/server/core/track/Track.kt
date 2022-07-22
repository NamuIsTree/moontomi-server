package com.moontomi.server.core.track

import com.moontomi.server.core.album.Album
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.IdClass
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "track")
@IdClass(value = TrackId::class)
class Track (
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    val album: Album,

    @Id
    @Column(name = "track_num")
    val num: Int,

    @Column(name = "name")
    val name: String
)

class TrackId (
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    val album: Album,

    @Column(name = "track_num")
    val num: Int
)
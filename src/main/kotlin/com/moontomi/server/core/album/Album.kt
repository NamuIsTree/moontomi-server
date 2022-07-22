package com.moontomi.server.core.album

import com.moontomi.server.core.artist.Artist
import com.moontomi.server.core.image.Image
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "album")
class Album (
    @Id
    @Column(name = "album_id")
    val id: Int,

    @JoinColumn(name = "artist_id")
    @OneToOne(fetch = FetchType.EAGER)
    val artist: Artist,

    @JoinColumn(name = "image_id")
    @OneToOne(fetch = FetchType.EAGER)
    val image: Image,

        @Column
    val release: LocalDateTime
)

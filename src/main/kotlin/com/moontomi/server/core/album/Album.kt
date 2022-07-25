package com.moontomi.server.core.album

import com.moontomi.server.core.artist.Artist
import com.moontomi.server.core.common.IntListConverter
import com.moontomi.server.core.common.StringListConverter
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "album")
class Album (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    val id: Int?,

    @JoinColumn(name = "artist_id")
    @OneToOne(fetch = FetchType.EAGER)
    val artist: Artist,

    @Column(name = "image_id")
    val imageId: Int,

    @Convert(converter = IntListConverter::class)
    @Column(columnDefinition = "json")
    val genres: List<Int>,

    @Convert(converter = StringListConverter::class)
    @Column(columnDefinition = "json")
    val tracks: List<String>,

    @Column
    val release: LocalDateTime
)
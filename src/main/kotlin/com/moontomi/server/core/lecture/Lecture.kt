package com.moontomi.server.core.lecture

import com.moontomi.server.core.album.Album
import com.moontomi.server.core.season.Season
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "lecture")
class Lecture (
    @Id
    @Column(name = "lecture_id")
    val id: Int,

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")
    val album: Album,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "season_id")
    val season: Season,

    @Column(name = "ymd")
    val ymd: LocalDateTime
)
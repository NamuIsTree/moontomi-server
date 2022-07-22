package com.moontomi.server.core.lecturecomment

import com.moontomi.server.core.lecture.Lecture
import com.moontomi.server.core.track.Track
import javax.persistence.*

@Entity
@Table(name = "lecture_comment")
class LectureComment (
    @Id
    @Column(name = "lecture_comment_id")
    val id: Int,

    @Column(name = "user_name")
    val userName: String,

    @Column(name = "rating")
    val rating: Int,

    @JoinColumns(
        JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id"),
        JoinColumn(name = "best1", referencedColumnName = "track_id")
    )
    val best1: Track,

    @JoinColumns(
        JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id"),
        JoinColumn(name = "best2", referencedColumnName = "track_id")
    )
    val best2: Int,

    @JoinColumns(
        JoinColumn(name = "lecture_id", referencedColumnName = "lecture_id"),
        JoinColumn(name = "best3", referencedColumnName = "track_id")
    )
    val best3: Int,

    @Column(name = "comment")
    val comment: String
)
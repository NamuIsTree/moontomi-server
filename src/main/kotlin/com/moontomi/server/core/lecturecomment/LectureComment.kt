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

    @Column
    val best1: Int,

    @Column
    val best2: Int,

    @Column
    val best3: Int,

    @Column(name = "comment")
    val comment: String
)
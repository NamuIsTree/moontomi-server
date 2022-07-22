package com.moontomi.server.core.lecturecomment

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LectureCommentRepository : JpaRepository<LectureComment, Int>
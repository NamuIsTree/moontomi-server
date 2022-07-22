package com.moontomi.server.core.lecture

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface LectureRepository : JpaRepository<Lecture, Int>
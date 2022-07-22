package com.moontomi.server.core.track

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrackRepository : JpaRepository<Track, TrackId>
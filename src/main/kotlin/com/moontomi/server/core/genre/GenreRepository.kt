package com.moontomi.server.core.genre

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GenreRepository : JpaRepository<Genre, Int> {

    fun findByCategory(category: GenreCategory): List<Genre>
}

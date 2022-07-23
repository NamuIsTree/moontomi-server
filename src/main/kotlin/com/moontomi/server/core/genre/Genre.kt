package com.moontomi.server.core.genre

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "genre")
class Genre (
    @Id
    @Column(name = "genre_id")
    var id: Int,

    @Column(name = "category")
    var category: GenreCategory,

    @Column(name = "name")
    var name: String
)

enum class GenreCategory {
    POP, ROCK, JAZZ, ELECTRONIC, HIPHOP, RNB, WORLD, EXPERIMENTAL
}
package com.moontomi.server.core.genre

import javax.persistence.*

@Entity
@Table(name = "genre")
class Genre (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id")
    var id: Int?,

    @Column(name = "category")
    var category: GenreCategory,

    @Column(name = "name")
    var name: String
)

enum class GenreCategory {
    POP, ROCK, JAZZ, ELECTRONIC, HIPHOP, RNB, WORLD, EXPERIMENTAL
}
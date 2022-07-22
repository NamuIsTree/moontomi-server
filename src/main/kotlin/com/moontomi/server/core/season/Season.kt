package com.moontomi.server.core.season

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "season")
class Season (
    @Id
    @Column(name = "season_id")
    val id: Int,

    @Column(name = "name")
    val name: String
)
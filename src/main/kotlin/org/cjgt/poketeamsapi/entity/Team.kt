package org.cjgt.poketeamsapi.entity

import jakarta.persistence.*

@Entity
data class Team(
    @Id
    val id: Long = 0,

    @ElementCollection
    var pokemonIds: MutableList<Int> = mutableListOf()
) {
    override fun toString(): String {
        return "Team(id=$id, pokemonIds=$pokemonIds)"
    }
}
package org.cjgt.poketeamsapi.entity

import jakarta.persistence.*

@Entity
data class Team(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ElementCollection
    val pokemonIds: List<Int> = emptyList()
) {
    override fun toString(): String {
        return "Team(id=$id, pokemonIds=$pokemonIds)"
    }
}
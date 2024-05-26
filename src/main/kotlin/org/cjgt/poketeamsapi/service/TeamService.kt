package org.cjgt.poketeamsapi.service

import org.cjgt.poketeamsapi.entity.Team
import org.cjgt.poketeamsapi.repository.TeamRepository
import org.springframework.stereotype.Service

@Service
class TeamService(private val teamRepository: TeamRepository) {

    fun createTeam(pokemonIds: MutableList<Int>): Team {
        val team = Team(pokemonIds = pokemonIds)
        return teamRepository.save(team)
    }

    fun createTeam(id: Long, pokemonIds: MutableList<Int>): Team {
        val team = Team(id = id, pokemonIds = pokemonIds)
        return teamRepository.save(team)
    }

    fun getTeam(id: Long): Team? {
        return teamRepository.findById(id).orElse(null)
    }

    fun getAllTeams(): List<Team> {
        return teamRepository.findAll()
    }

    fun updateTeam(id: Long, pokemonIds: MutableList<Int>): Team? {
        val team = getTeam(id) ?: return null
        val updatedTeam = team.copy(pokemonIds = pokemonIds)
        return teamRepository.save(updatedTeam)
    }

    fun deleteTeam(id: Long) {
        teamRepository.deleteById(id)
    }

    fun existsById(id: Long): Boolean {
        return teamRepository.existsById(id)
    }
}
package org.cjgt.poketeamsapi.controller

import org.cjgt.poketeamsapi.entity.Team
import org.cjgt.poketeamsapi.service.TeamService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/teams")
class TeamController(private val teamService: TeamService) {

    @PostMapping
    fun createTeam(@RequestBody pokemonIds: MutableList<Int>): ResponseEntity<Team> {
        val team = teamService.createTeam(pokemonIds)
        return ResponseEntity(team, HttpStatus.CREATED)
    }

    @PostMapping("/{id}")
    fun createTeam(@PathVariable id: Long, @RequestBody pokemonIds: MutableList<Int>): ResponseEntity<Team> {
        val team = teamService.createTeam(id, pokemonIds)
        return ResponseEntity(team, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getTeam(@PathVariable id: Long): ResponseEntity<Team> {
        val team = teamService.getTeam(id)
        return if (team != null) ResponseEntity(team, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @GetMapping
    fun getAllTeams(): ResponseEntity<List<Team>> {
        val teams = teamService.getAllTeams()
        return ResponseEntity(teams, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateTeam(@PathVariable id: Long, @RequestBody pokemonIds: MutableList<Int>): ResponseEntity<Team> {
        val team = teamService.updateTeam(id, pokemonIds)
        return if (team != null) ResponseEntity(team, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @DeleteMapping("/{id}")
    fun deleteTeam(@PathVariable id: Long): ResponseEntity<Void> {
        return if (teamService.existsById(id)) {
            teamService.deleteTeam(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
package org.cjgt.poketeamsapi.repository

import org.cjgt.poketeamsapi.entity.Team
import org.springframework.data.jpa.repository.JpaRepository

interface TeamRepository : JpaRepository<Team, Long>
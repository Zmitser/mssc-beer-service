package by.zmitser.msscbeerservice.repository

import by.zmitser.msscbeerservice.domain.Beer
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface BeerRepository : JpaRepository<Beer, UUID>

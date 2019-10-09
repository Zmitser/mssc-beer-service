package by.zmitser.msscbeerservice.web.controller

import by.zmitser.msscbeerservice.web.model.BeerDto
import org.springframework.http.HttpStatus.*
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("/api/v1/beer")
@RestController
class BeerController {


    @GetMapping("/{id}")
    fun findOne(@PathVariable id: UUID) = ResponseEntity(BeerDto(), OK)

    @PostMapping
    fun save(@RequestBody beer: BeerDto): ResponseEntity<Any> = ResponseEntity(CREATED)

    @PutMapping("/{id}")
    fun update(@PathVariable id: UUID, @RequestBody beer: BeerDto): ResponseEntity<Any> = ResponseEntity(NO_CONTENT)
}
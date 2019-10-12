package by.zmitser.msscbeerservice.web.controller

import by.zmitser.msscbeerservice.web.model.BeerDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*
import java.util.UUID.*

@WebMvcTest(BeerController::class)
class BeerControllerTest(@Autowired private val mockMvc: MockMvc, @Autowired private val mapper: ObjectMapper) {


    @Test
    fun findOne() {
        mockMvc.perform(get("/api/v1/beers/${randomUUID()}").accept(APPLICATION_JSON)).andExpect(status().isOk)
    }

    @Test
    fun save() {
        val beer: BeerDto = BeerDto()
        val beerJson = mapper.writeValueAsString(beer)
        mockMvc.perform(post("/api/v1/beers")
                .contentType(APPLICATION_JSON)
                .content(beerJson))
                .andExpect(status().isCreated)
    }

    @Test
    fun update() {
        val beer: BeerDto = BeerDto()
        val beerJson = mapper.writeValueAsString(beer)

        mockMvc.perform(put("/api/v1/beers/${randomUUID()}")
                .contentType(APPLICATION_JSON)
                .content(beerJson))
                .andExpect(status().isNoContent)
    }
}
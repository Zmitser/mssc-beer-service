package by.zmitser.msscbeerservice.web.controller

import by.zmitser.msscbeerservice.web.model.BeerDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.constraints.ConstraintDescriptions
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import org.springframework.restdocs.payload.FieldDescriptor
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.request.RequestDocumentation.*
import org.springframework.restdocs.snippet.Attributes.key
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.util.StringUtils
import java.util.UUID.randomUUID


@ExtendWith(RestDocumentationExtension::class)
@AutoConfigureRestDocs
@WebMvcTest(BeerController::class)
class BeerControllerTest(@Autowired private val mockMvc: MockMvc, @Autowired private val mapper: ObjectMapper) {


    @Test
    fun findOne() {
        mockMvc.perform(get("/api/v1/beers/{beerId}", randomUUID())
                .param("isCold", "yes")
                .accept(APPLICATION_JSON))
                .andExpect(status().isOk)
                .andDo(
                        document("v1/beers-get",
                                pathParameters(
                                        parameterWithName("beerId").description("UUID of desired beer to get.")
                                ),
                                requestParameters(
                                        parameterWithName("isCold").description("Is beer cold query param")
                                ),
                                responseFields(
                                        fieldWithPath("id").description("Id of Beer"),
                                        fieldWithPath("version").description("Version number"),
                                        fieldWithPath("createdDate").description("Date Created"),
                                        fieldWithPath("lastModifiedDate").description("Date Updated"),
                                        fieldWithPath("beerName").description("Beer Name"),
                                        fieldWithPath("beerStyle").description("Beer Style"),
                                        fieldWithPath("upc").description("UPC of Beer"),
                                        fieldWithPath("price").description("Price"),
                                        fieldWithPath("quantityOnHand").description("Quantity On hand")
                                )
                        )
                )

    }

    @Test
    fun save() {
        val beer = BeerDto()
        val beerJson = mapper.writeValueAsString(beer)

        val fields: ConstrainedFields = ConstrainedFields(beer::class.java)
        mockMvc.perform(post("/api/v1/beers")
                .contentType(APPLICATION_JSON)
                .content(beerJson))
                .andExpect(status().isCreated)
                .andDo(document("v1/beers-new",
                        requestFields(
                                fields.withPath("id").ignored(),
                                fields.withPath("version").ignored(),
                                fields.withPath("createdDate").ignored(),
                                fields.withPath("lastModifiedDate").ignored(),
                                fields.withPath("beerName").description("Name of the beer"),
                                fields.withPath("beerStyle").description("Style of Beer"),
                                fields.withPath("upc").description("Beer UPC").attributes(),
                                fields.withPath("price").description("Beer Price"),
                                fields.withPath("quantityOnHand").ignored()
                        )))
    }

    @Test
    fun update() {
        val beer = BeerDto()
        val beerJson = mapper.writeValueAsString(beer)

        mockMvc.perform(put("/api/v1/beers/${randomUUID()}")
                .contentType(APPLICATION_JSON)
                .content(beerJson))
                .andExpect(status().isNoContent)
    }

    private class ConstrainedFields internal constructor(input: Class<*>) {

        private val constraintDescriptions: ConstraintDescriptions = ConstraintDescriptions(input)

        fun withPath(path: String): FieldDescriptor {
            return fieldWithPath(path).attributes(key("constraints").value(StringUtils
                    .collectionToDelimitedString(this.constraintDescriptions
                            .descriptionsForProperty(path), ". ")))
        }
    }
}
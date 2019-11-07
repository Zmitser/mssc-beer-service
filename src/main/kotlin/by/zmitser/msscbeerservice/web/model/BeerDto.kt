package by.zmitser.msscbeerservice.web.model

import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Null
import javax.validation.constraints.Positive

data class BeerDto(
        @Null
        val id: UUID?,
        @Null
        val version: Int?,
        @Null
        val creationDate: OffsetDateTime?,
        @Null
        val lastModifiedDate: OffsetDateTime?,
        @NotBlank
        val beerName: String?,
        @NotNull
        val beerStyle: BeerStyleEnum?,
        @NotNull
        @Positive
        val upc: Long?,
        @NotNull
        @Positive
        val price: BigDecimal?,
        val quantityOnHand: Int?) {
    constructor() : this(null, null, null, null, null, null, null, null, null)

    enum class BeerStyleEnum {
        LAGER, PILSNER, STOUT, GOSE, PORTER, ALE, WHEAT, IPA, PALE_ALE, SAILSON
    }
}
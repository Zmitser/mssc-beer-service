package by.zmitser.msscbeerservice.web.model

import com.github.pozo.KotlinBuilder
import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Null
import javax.validation.constraints.Positive

@KotlinBuilder
data class BeerDto(
        @Null
        var id: UUID?,
        @Null
        var version: Int?,
        @Null
        var createdDate: OffsetDateTime?,
        @Null
        val lastModifiedDate: OffsetDateTime?,
        @NotBlank
        var beerName: String?,
        @NotNull
        var beerStyle: BeerStyleEnum?,
        @NotNull
        @Positive
        var upc: Long?,
        @NotNull
        @Positive
        var price: BigDecimal?,
        var quantityOnHand: Int?) {
    constructor() : this(null, null, null, null, null, null, null, null, null)

    enum class BeerStyleEnum {
        LAGER, PILSNER, STOUT, GOSE, PORTER, ALE, WHEAT, IPA, PALE_ALE, SAILSON
    }
}
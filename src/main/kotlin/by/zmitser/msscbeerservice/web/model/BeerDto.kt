package by.zmitser.msscbeerservice.web.model

import java.math.BigDecimal
import java.time.OffsetDateTime
import java.util.*

data class BeerDto(val id: UUID,
                   val version: Int,
                   val creationDate: OffsetDateTime,
                   val lastModifiedDate: OffsetDateTime,
                   val beerStyle: BeerStyleEnum,
                   val upc: Long,
                   val price: BigDecimal,
                   val quantityOnHand: Int) {

    enum class BeerStyleEnum {
        LAGER, PILSNER, STOUT, GOSE, PORTER, ALE, WHEAT, IPA, PALE_ALE, SAILSON
    }
}
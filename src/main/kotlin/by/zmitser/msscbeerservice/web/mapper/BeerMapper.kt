package by.zmitser.msscbeerservice.web.mapper

import by.zmitser.msscbeerservice.domain.Beer
import by.zmitser.msscbeerservice.web.model.BeerDto
import org.mapstruct.Mapper

@Mapper(
        componentModel = "spring",
        uses = [DateMapper::class]
)
interface BeerMapper {

    fun beerToBeerDto(beer: Beer): BeerDto

    fun beerDtoToBeer(beerDto: BeerDto): Beer
}
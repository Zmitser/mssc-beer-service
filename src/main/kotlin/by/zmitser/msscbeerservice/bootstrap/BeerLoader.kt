package by.zmitser.msscbeerservice.bootstrap

import by.zmitser.msscbeerservice.domain.BeerBuilder
import by.zmitser.msscbeerservice.repository.BeerRepository
import mu.KLogger
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class BeerLoader(val beerRepository: BeerRepository) : CommandLineRunner {

    private val logger: KLogger = KotlinLogging.logger { }

    override fun run(vararg args: String?) {
        loadBeerObjects()
    }


    private fun loadBeerObjects() {
        if (beerRepository.count() == 0L) {
            beerRepository.save(BeerBuilder.builder()
                    .setBeerName("Mango Bobs")
                    .setBeerStyle("IPA")
                    .setUpc(333000000001L)
                    .setPrice(BigDecimal("12.95"))
                    .setQuantityToBrew(200)
                    .setMinOnHand(12)
                    .create())
            beerRepository.save(BeerBuilder.builder()
                    .setBeerName("Galaxy Cat")
                    .setBeerStyle("PALE_ALE")
                    .setUpc(333000000002L)
                    .setPrice(BigDecimal("11.95"))
                    .setQuantityToBrew(200)
                    .setMinOnHand(12)
                    .create())
        }

        logger.info { beerRepository.count() }
    }
}
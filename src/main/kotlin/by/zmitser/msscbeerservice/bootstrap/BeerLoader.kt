package by.zmitser.msscbeerservice.bootstrap

import by.zmitser.msscbeerservice.domain.Beer
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
            beerRepository.save(Beer("Mango Bobs", "IPA", 333000000001L, BigDecimal("12.95"), 200, 12))
            beerRepository.save(Beer("Galaxy Cat", "PALE_ALE", 333000000002L, BigDecimal("11.95"), 200, 12))
        }

        logger.info { beerRepository.count() }
    }
}
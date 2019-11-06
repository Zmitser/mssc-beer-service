package by.zmitser.msscbeerservice.domain

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.UpdateTimestamp
import java.math.BigDecimal
import java.sql.Timestamp
import java.util.*
import javax.persistence.*

@Entity
data class Beer(
        @Id
        @GeneratedValue(generator = "UUID")
        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
        val id: UUID,
        @Version
        val version: Long,
        @CreationTimestamp
        @Column(updatable = false)
        val createdDate: Timestamp,
        @UpdateTimestamp
        val lastModifiedDate: Timestamp,
        val beerName: String,
        val beerStyle: String,
        @Column(unique = true)
        val upc: Long,
        val price: BigDecimal,
        val minOnHand: Int,
        val quantityToBrew: Int) {
}
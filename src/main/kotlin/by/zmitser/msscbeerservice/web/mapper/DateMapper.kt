package by.zmitser.msscbeerservice.web.mapper

import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.OffsetDateTime
import java.time.ZoneOffset

@Component
class DateMapper {

    fun asOffsetDateTime(ts: Timestamp?): OffsetDateTime? {
        return if (ts != null) {
            OffsetDateTime.of(ts.toLocalDateTime().year, ts.toLocalDateTime().monthValue,
                    ts.toLocalDateTime().dayOfMonth, ts.toLocalDateTime().hour, ts.toLocalDateTime().minute,
                    ts.toLocalDateTime().second, ts.toLocalDateTime().nano, ZoneOffset.UTC)
        } else {
            null
        }
    }

    fun asTimestamp(offsetDateTime: OffsetDateTime?): Timestamp? {
        return if (offsetDateTime != null) {
            Timestamp.valueOf(offsetDateTime.atZoneSameInstant(ZoneOffset.UTC).toLocalDateTime())
        } else {
            null
        }
    }
}
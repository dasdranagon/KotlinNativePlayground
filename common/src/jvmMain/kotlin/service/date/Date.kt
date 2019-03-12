package service.date
import java.text.SimpleDateFormat
import java.util.Date

actual typealias Date = Date

actual class DateFormatter {
    private val formatter: SimpleDateFormat
    actual constructor(format: String) {
        formatter = SimpleDateFormat(format)
    }

    actual fun date(fromString: String): Date? = formatter.parse(fromString)

    actual fun string(fromDate: Date): String = formatter.format(fromDate)
}